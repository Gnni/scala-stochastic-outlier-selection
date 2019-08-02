Stochastic Outlier Selection on Apache Spark
============================

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/1edb4375f12d4509a2d5c529c6cf70ce)](https://app.codacy.com/app/Gnni/scala-stochastic-outlier-selection?utm_source=github.com&utm_medium=referral&utm_content=Gnni/scala-stochastic-outlier-selection&utm_campaign=Badge_Grade_Dashboard)
[![Codacy Badge](https://www.codacy.com/project/badge/9069624e46ac4d97bb19a34705f95965)](https://www.codacy.com)
[![Build Status](https://travis-ci.org/Fokko/spark-stochastic-outlier-selection.svg?branch=master)](https://travis-ci.org/Fokko/spark-stochastic-outlier-selection)
[![Coverage Status](https://coveralls.io/repos/Fokko/spark-stochastic-outlier-selection/badge.svg?branch=master&service=github)](https://coveralls.io/github/Fokko/spark-stochastic-outlier-selection?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/frl.driesprong/spark-stochastic-outlier-selection_2.11/badge.svg)](https://maven-badges.herokuapp.com/maven-central/frl.driesprong/spark-stochastic-outlier-selection_2.11)

Stochastic Outlier Selection (SOS) is an unsupervised outlier selection algorithm. It uses the concept of affinity to compute an outlier probability for each data point.

For more information about SOS, see the technical report: J.H.M. Janssens, F. Huszar, E.O. Postma, and H.J. van den Herik. [Stochastic Outlier Selection](https://github.com/jeroenjanssens/sos/blob/master/doc/sos-ticc-tr-2012-001.pdf?raw=true). Technical Report TiCC TR 2012-001, Tilburg University, Tilburg, the Netherlands, 2012.

Selecting outliers from data
----------------------------------------

The current implementation accepts RDD's of the type `Array[Double]` and returns the indexes of the vector with it's degree of outlierness.

Current implementation only works with Euclidean distance, but this will be extended in the foreseeable future.
