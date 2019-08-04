ThisBuild / organization := "com.github.gnni"
ThisBuild / organizationName := "Hasso Plattner Institute, University of Potsdam"
ThisBuild / organizationHomepage := Some(url("https://hpi.de"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/Gnni/scala-stochastic-outlier-selection"),
    "scm:git@github.com:Gnni/scala-stochastic-outlier-selection.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "guenterhesse",
    name  = "Guenter Hesse",
    email = "guenter.hesse@hpi.de",
    url   = url("https://hpi.de/plattner/people/phd-students/guenter-hesse.html")
  )
)

ThisBuild / description := "Scala version of Stochastic Outlier Selection"
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/Gnni/scala-stochastic-outlier-selection"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
ThisBuild / publishArtifact in Test := false