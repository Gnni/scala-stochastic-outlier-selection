
name := "Scala Stochastic Outlier Selection"

version := "0.1.0"

//publishTo := {
//  val nexus = "https://oss.sonatype.org/"
//  if (isSnapshot.value)
//    Some("snapshots" at nexus + "content/repositories/snapshots")
//  else
//    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
//}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.0"

libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.2.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.5" % "test"
