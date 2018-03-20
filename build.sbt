name := "learnspark"

version := "0.1"

scalaVersion := "2.10.5"
//libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.0" % "provided"excludeAll(ExclusionRule(organization = "org.scala-lang.modules"))

libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.6.0"excludeAll(ExclusionRule(organization = "org.scala-lang.modules"))
libraryDependencies += "org.apache.commons" % "commons-compress" % "1.11"
libraryDependencies += "com.databricks" %% "spark-csv" % "1.1.0"


