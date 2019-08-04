Stochastic Outlier Selection in Scala
============================

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/df5fc23eb5b74795b62d0daa52436a0d)](https://www.codacy.com/app/Gnni/scala-stochastic-outlier-selection?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Gnni/scala-stochastic-outlier-selection&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Gnni/scala-stochastic-outlier-selection.svg?branch=master)](https://travis-ci.org/Gnni/scala-stochastic-outlier-selection)
[![Coverage Status](https://coveralls.io/repos/github/Gnni/scala-stochastic-outlier-selection/badge.svg?branch=master)](https://coveralls.io/github/Gnni/scala-stochastic-outlier-selection?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.gnni/scala-stochastic-outlier-selection_2.11/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.gnni/scala-stochastic-outlier-selection_2.11)

Adapted version of the implementation for Apache Spark. This versions
aims to perform Stochastic Outlier Selection (SOS) using Scala only,
i.e., w/o the need of any Apache Spark resources.

SOS is an unsupervised outlier selection algorithm. It uses the concept of affinity to compute an outlier probability for each data point.

For more information about SOS, see the technical report: J.H.M.
Janssens, F. Huszar, E.O. Postma, and H.J. van den Herik.
[Stochastic Outlier Selection](https://github.com/jeroenjanssens/sos/blob/master/doc/sos-ticc-tr-2012-001.pdf?raw=true).
Technical Report TiCC TR 2012-001, Tilburg University, Tilburg, the
Netherlands, 2012.

Selecting outliers from data
----------------------------------------

The current implementation accepts an Array with elements of the type
`Array[Double]` and returns the indexes of the vector with it's degree
of outlierness.

Current implementation only works with Euclidean distance.
