## qw.scala

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

#### Advanced usage

You can embed `String` variable into notation:

```scala
import com.github.windymelt.qw.Syntax._

val (x, y, z) = ("a", "b", "c")

val lis: List[String] = qw"$a $b $c" // => List("a", "b", "c")
val lis2: List[String] = qw"$a$b$c"  // => List("a", "b", "c")
```
