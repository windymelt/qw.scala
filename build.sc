import mill._, scalalib._

object qw extends RootModule with ScalaModule {
  def scalaVersion = "3.3.0"
  def publishVersion = "0.1.1-SNAPSHOT"
  object test extends ScalaTests with TestModule.Munit {
    def ivyDeps = Agg(ivy"org.scalameta::munit::0.7.29")
  }
}
