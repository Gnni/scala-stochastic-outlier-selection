package frl.driesprong.outlierdectection

import breeze.linalg.{DenseVector, sum}
import breeze.numerics.{pow, sqrt}
import scala.language.implicitConversions

object StochasticOutlierDetection {
  val DefaultTolerance = 1e-20
  val DefaultIterations = 500
  val DefaultPerplexity = 30.0

  def performOutlierDetection(inputVectors: Array[Array[Double]],
                              perplexity: Double = DefaultPerplexity,
                              tolerance: Double = DefaultTolerance,
                              maxIterations: Int = DefaultIterations): Array[(Long, Double)] = {

    val dMatrix = StochasticOutlierDetection.computeDistanceMatrix(inputVectors)
    val aMatrix = StochasticOutlierDetection.computeAffinityMatrix(dMatrix, perplexity, maxIterations, tolerance)
    val bMatrix = StochasticOutlierDetection.computeBindingProbabilities(aMatrix)
    val oMatrix = StochasticOutlierDetection.computeOutlierProbability(bMatrix)
    oMatrix
  }

  def binarySearch(affinity: DenseVector[Double],
                   logPerplexity: Double,
                   maxIterations: Int,
                   tolerance: Double,
                   iteration: Int = 0,
                   beta: Double = 1.0,
                   betaMin: Double = Double.NegativeInfinity,
                   betaMax: Double = Double.PositiveInfinity): DenseVector[Double] = {

    val newAffinity = affinity.map(d => Math.exp(-d * beta))
    val sumA = sum(newAffinity)
    val hCurr = Math.log(sumA) + beta * sum(affinity :* newAffinity) / sumA
    val hDiff = hCurr - logPerplexity

    if (iteration < maxIterations && Math.abs(hDiff) > tolerance) {
      val search = if (hDiff > 0)
        (if (betaMax == Double.PositiveInfinity || betaMax == Double.NegativeInfinity)
          beta * 2.0
        else
          (beta + betaMax) / 2.0, beta, betaMax)
      else
        (if (betaMin == Double.PositiveInfinity || betaMin == Double.NegativeInfinity)
          beta / 2.0
        else
          (beta + betaMin) / 2.0, betaMin, beta)

      binarySearch(affinity, logPerplexity, maxIterations, tolerance, iteration + 1, search._1, search._2, search._3)
    }
    else
      newAffinity
  }

  def computeAffinityMatrix(dMatrix: Array[(Long, Array[Double])],
                            perplexity: Double = DefaultPerplexity,
                            maxIterations: Int,
                            tolerance: Double): Array[(Long, DenseVector[Double])] = {
    val logPerplexity = Math.log(perplexity)
    dMatrix.map(r => (r._1, binarySearch(new DenseVector(r._2), logPerplexity, maxIterations, tolerance)))
  }

  def euclDistance(a: Array[Double], b: Array[Double]): Double = sqrt((a zip b).map { case (x, y) => pow(y - x, 2) }.sum)

  def computeBindingProbabilities(rows: Array[(Long, DenseVector[Double])]): Array[(Long, Array[Double])] =
    rows.map(r => (r._1, (r._2 :/ sum(r._2)).toArray))

  def computeDistanceMatrix(data: Array[Array[Double]]): Array[(Long, Array[Double])] = computeDistanceMatrixPair(data.zipWithIndex.map(tuple => (tuple._2.toLong, tuple._1)))

  def computeDistanceMatrixPair(data: Array[(Long, Array[Double])]): Array[(Long, Array[Double])] = {
    data.flatMap(x => data.map(y => (x, y))).
      flatMap {
        case (a: (Long, Array[Double]), b: (Long, Array[Double])) =>
          if (a._1 != b._1)
            Some(a._1, euclDistance(a._2, b._2))
          else
            None
      }.
      groupBy(_._1).
      mapValues(arrayLongDouble => {
        arrayLongDouble.foldLeft(Array[Double]())((a, b) =>
          a :+ b._2
        )
      }).
      toArray
  }

  def computeOutlierProbability(rows: Array[(Long, Array[Double])]):
  Array[(Long, Double)] =
    rows.flatMap(r => r._2.zipWithIndex.map(p =>
      (p._2 + (if (p._2 >= r._1) 1L else 0L), p._1))).
      groupBy(_._1).
      mapValues(arrayLongDouble => {
        arrayLongDouble.foldLeft(1.0)((a, b) => a * (1.0 - b._2))
      }).toArray
}
