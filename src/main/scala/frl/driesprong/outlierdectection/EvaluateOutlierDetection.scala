package frl.driesprong.outlierdectection

object EvaluateOutlierDetection {

  def main(args: Array[String]) {

    val testDataset = Array(
      (Array(1.00, 1.00)),
      (Array(2.00, 1.00)),
      (Array(1.00, 2.00)),
      (Array(2.00, 2.00)),
      (Array(5.00, 8.00))
    )

    StochasticOutlierDetection.performOutlierDetection(testDataset, perplexity = 3.0).foreach( x =>
      System.out.println(x._1 + " : " + x._2)
    )
  }
}
