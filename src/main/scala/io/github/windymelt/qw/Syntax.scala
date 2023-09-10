package io.github.windymelt.qw

/** Enables qw syntax for string.
  *
  * {{{
  * import io.github.windymelt.qw.Syntax.{*, given}
  * qw"foo bar buzz" // => "foo" :: "bar" :: "buzz" :: Nil
  * }}}
  *
  * You can use newline for separator too:
  *
  * {{{
  * qw"""
  * new
  * line
  * separated
  * """ // => "new" :: "line" :: "separated" :: Nil
  * }}}
  */
object Syntax:
  extension (sc: StringContext)
    /** Splits strings with whitespace character and constructs
      * [[List[String]]].
      */
    def qw(args: String*): List[String] =
      val strings = sc.parts.iterator
      val expressions = args.iterator
      var buf = collection.mutable.ListBuffer(strings.next().split("\\s")*)
      while strings.hasNext do
        buf.append(expressions.next().toString)
        buf.append(strings.next().toString.split("\\s")*)
      buf.filterNot(_.isEmpty).toList
