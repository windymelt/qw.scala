## qw.scala [![CI](https://github.com/windymelt/qw.scala/actions/workflows/ci.yaml/badge.svg?branch=main)](https://github.com/windymelt/qw.scala/actions/workflows/ci.yaml)

This library ports `qw()` syntax from Perl.

You can save time from double quotation hell when coding long `String` list.

### Usage

Usage is very simple!

#### Basic usage

Instead of writing `List[String](...)` directly, you can express it writing space-separated string:

```scala
import com.github.windymelt.qw.Syntax._

val lis: List[String] = qw"You can save time from double-quotation hell"
// => List("You", "can", "save", "time", "from", "double-quotation", "hell")
```

You can express list via multi-line:

```scala
val lis = qw"""
a b
c d
e f
"""
// => List("a", "b", "c", "d", "e", "f")
```

#### Advanced usage

You can embed `String` variable into notation:

```scala
import com.github.windymelt.qw.Syntax._

val (x, y, z) = ("a", "b", "c")

val lis: List[String] = qw"$a $b $c" // => List("a", "b", "c")
val lis2: List[String] = qw"$a$b$c"  // => List("a", "b", "c")
```
