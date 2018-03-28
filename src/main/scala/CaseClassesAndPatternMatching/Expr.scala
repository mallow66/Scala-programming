package CaseClassesAndPatternMatching

/**
  * Created by brahim on 3/3/18.
  */

/*
a sealed class connot have any new subclasses added except the ones
in the same file
 */
sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num : Double) extends Expr
case class UnOp(operator: String, args : Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

/*
classes with the modifier `case` are called case classes
 */

/*
with using this modifier `case`, Scala compiler add some syntactic
conveniences to your class.
 */

/*

1 - it adds a factory method with the name of the class (you can write Var("x") instead of new Var("x")
to construct a Var object)

2 - all arguments un the parameter list of a case class implicitly get a val prefix,
so they're maintained as fileds

3 - Scala compiler adds 'natural' implementations of methods :
toString, hashCode, equals.
they will print, hash and compare a whole tree consisting of the class
and (recursively) all its arguments.
In scala == always delegats to equalts, this means that elements of case classes
are always compared structurally

4 - the compiler adds a `copy ` method to the class for making
modified copies.
we specify the changes we would like to make by using named parameters.
For any parameter you don't specify
 */




