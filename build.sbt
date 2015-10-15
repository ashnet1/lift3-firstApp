name := "firstApp"

version := "0.1.0"

scalaVersion := "2.11.7"

resolvers ++= Seq(
  "Java.net Maven2 Repository"     at "http://download.java.net/maven/2/",
  "Sonatype scala-tools repo"      at "https://oss.sonatype.org/content/groups/scala-tools/",
  "snapshots"     at "https://oss.sonatype.org/content/repositories/snapshots",
  "releases"      at "https://oss.sonatype.org/content/repositories/releases"
)

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Xfuture", "-Ydelambdafy:method", "-Ybackend:GenBCode", "-target:jvm-1.8")

libraryDependencies ++= {
  val liftVersion = "3.0-SNAPSHOT"
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile",
    "net.liftweb" %% "lift-squeryl-record" % liftVersion,
    "postgresql" % "postgresql" % "8.2-507.jdbc4",
    "org.scalatest" % "scalatest_2.11" % "2.2.5",
    "org.eclipse.jetty" % "jetty-webapp" % "9.3.1.v20150714" % "container,test",
    "com.typesafe.akka" % "akka-actor_2.11" % "2.3.12",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" %  "container,compile" artifacts Artifact("javax.servlet", "jar", "jar")
  )
}

// use jetty:start/stop
enablePlugins(JettyPlugin)
containerLibs in Jetty := Seq("org.eclipse.jetty" % "jetty-runner" % "9.3.1.v20150714" intransitive())
containerMain in Jetty := "org.eclipse.jetty.runner.Runner"

//containerShutdownOnExit := false
