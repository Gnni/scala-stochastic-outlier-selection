
name := "Scala Stochastic Outlier Selection"

version := "0.1-SNAPSHOT"

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

lazy val core = (project in file("."))
  .settings(organization := "com.github.gnni")

publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/Gnni/scala-stochastic-outlier-selection</url>
    <licenses>
      <license>
        <name>The Apache License, Version 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      </license>
    </licenses>
    <scm>
      <connection>scm:git:git@github.com:Gnni/scala-stochastic-outlier-selection.git</connection>
      <developerConnection>scm:git:git@github.com:Gnni/scala-stochastic-outlier-selection.git</developerConnection>
      <url>git@github.com:Gnni/scala-stochastic-outlier-selection.git</url>
    </scm>
    <developers>
      <developer>
        <name>Guenter Hesse</name>
        <email>guenter.hesse@hpi.de</email>
        <url>https://hpi.de/plattner/people/phd-students/guenter-hesse.html</url>
        <organization>Hasso Plattner Institute, University of Potsdam</organization>
        <organizationUrl>https://hpi.de</organizationUrl>
        <role>PhD student</role>
        <timezone>Europe/Berlin</timezone>
      </developer>
    </developers>)

scalaVersion := "2.11.11"

libraryDependencies += "org.scalanlp" %% "breeze" % "0.13.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.5" % "test"
