package com.github.windymelt.qw

object Syntax:
  extension (sc: StringContext)
    def qw(args: String*): List[String] =
      val strings = sc.parts.iterator
      val expressions = args.iterator
      var buf = collection.mutable.ListBuffer(strings.next().split(" ")*)
      while strings.hasNext do
        buf.append(expressions.next().toString)
        buf.append(strings.next().toString.split(" ")*)
      buf.filterNot(_.isEmpty).toList
