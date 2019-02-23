import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "FunctionalPlaypen",
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
libraryDependencies += "net.liftweb" %% "lift-json" % "3.3.0"
libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.6.4"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.0-SNAP10"
libraryDependencies += "org.typelevel" %% "cats" % "0.9.0"
libraryDependencies += "org.typelevel" %% "cats-effect" % "0.3"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test


