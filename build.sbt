name := "IMS-Start-Scala"

version := "0.1"

scalaVersion := "2.13.4"

idePackagePrefix := Some("com.qa")

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
  "mysql" % "mysql-connector-java" % "8.0.11"
)