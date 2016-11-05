name := "scalacheck-cats"
version := "0.2.0-SNAPSHOT"
organization := "io.github.amrhassan"
scalaVersion := "2.12.0"
crossScalaVersions := Seq("2.10.6", "2.11.8")

libraryDependencies ++= Seq(
  "org.typelevel" % "cats-core_2.12.0-RC2" % "0.8.0",
  "org.scalacheck" %% "scalacheck" % "1.13.4"
)

pomExtra in Global := {
  <url>https://github.com/amrhassan/scalacheck-cats</url>
    <licenses>
      <license>
        <name>MIT</name>
        <url>https://opensource.org/licenses/MIT</url>
      </license>
    </licenses>
    <scm>
      <connection>scm:git:github.com/amrhassan/scalacheck-cats</connection>
      <developerConnection>scm:git:git@github.com:amrhassan/scalacheck-cats</developerConnection>
      <url>github.com/amrhassan/scalacheck-cats</url>
    </scm>
    <developers>
      <developer>
        <id>amrhassan</id>
        <name>Amr Hassan</name>
        <url>http://amrhassan.info</url>
      </developer>
    </developers>
}
