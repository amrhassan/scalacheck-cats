name := "scalacheck-cats"
organization := "io.github.amrhassan"
scalaVersion := "2.12.4"
crossScalaVersions := Seq("2.10.6", "2.11.8", scalaVersion.value)
releasePublishArtifactsAction := PgpKeys.publishSigned.value
releaseCrossBuild := true

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.0.0-RC1",
  "org.scalacheck" %% "scalacheck" % "1.13.4"
)

publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

licenses := Seq("MIT" -> url("http://www.opensource.org/licenses/mit-license.php"))
homepage := Some(url("https://amrhassan.github.io/scalacheck-cats"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/amrhassan/scalacheck-cats"),
    "scm:git@github.com:amrhassan/scalacheck-cats.git"
  )
)
developers := List(
  Developer(id="amrhassan", name="Amr Hassan", email="amr.hassan@gmail.com", url=url("http://amrhassan.info"))
)
