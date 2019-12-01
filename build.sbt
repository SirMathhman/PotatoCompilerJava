name := "PotatoCompilerJava"

version := "0.1"

scalaVersion := "2.13.1"

// https://mvnrepository.com/artifact/org.javatuples/javatuples
libraryDependencies += "org.javatuples" % "javatuples" % "1.2"

// https://mvnrepository.com/artifact/com.scalified/tree
libraryDependencies += "com.scalified" % "tree" % "0.2.5"

libraryDependencies += "net.openhft" % "compiler" % "2.3.4"

libraryDependencies += "org.junit.jupiter" % "junit-jupiter-api" % "5.+" % Test
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-engine" % "5.+" % Test
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-params" % "5.+" % Test

libraryDependencies += "org.mockito" % "mockito-core" % "2.+" % Test