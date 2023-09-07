import $ivy.`de.tototec::de.tobiasroeser.mill.vcs.version::0.4.0`
import de.tobiasroeser.mill.vcs.version.VcsVersion

import mill._, scalalib._
import publish._

object qw extends RootModule with ScalaModule with PublishModule {
  def scalaVersion = "3.3.0"

  override def artifactName = "qw"
  override def sonatypeUri = "https://s01.oss.sonatype.org/service/local"
  override def sonatypeSnapshotUri =
    "https://s01.oss.sonatype.org/content/repositories/snapshots"
  def pomSettings = PomSettings(
    description = artifactName(),
    organization = "io.github.windymelt",
    url = "https://github.com/windymelt/qw.scala",
    licenses = Seq(License.`BSD-3-Clause`),
    versionControl = VersionControl.github("windymelt", "qw.scala"),
    developers = Seq(
      Developer("windymelt", "windymelt", "https://github.com/windymelt")
    )
  )
  override def publishVersion: T[String] = VcsVersion.vcsState().format()

  object test extends ScalaTests with TestModule.Munit {
    def ivyDeps = Agg(ivy"org.scalameta::munit::0.7.29")
  }
}
