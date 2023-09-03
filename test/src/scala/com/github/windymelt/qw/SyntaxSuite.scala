package io.github.windymelt.qw

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class SyntaxSuite extends munit.FunSuite {
  import Syntax._

  test("qw\"\" returns Nil") {
    assertEquals(qw"", Nil)
  }

  test("qw\"foo\" returns List(foo)") {
    assertEquals(qw"foo", List("foo"))
  }

  test("qw\"foo bar buzz\" returns List(foo, bar, buzz)") {
    assertEquals(qw"foo bar buzz", List("foo", "bar", "buzz"))
  }

  test("qw\"$x $y $z\" where x,y,z = a,b,c returns List(a, b, c)") {
    val (x, y, z) = ("a", "b", "c")
    assertEquals(qw"$x $y $z", List("a", "b", "c"))
  }

  test("qw\"$x$y$z\" where x,y,z = a,b,c returns List(a, b, c)") {
    val (x, y, z) = ("a", "b", "c")
    assertEquals(qw"$x$y$z", List("a", "b", "c"))
  }

  test("multiple line can be converted into list") {
    val lis = qw"""
a
b c
d  e
    """
    assertEquals(lis, List("a", "b", "c", "d", "e"))
  }
}
