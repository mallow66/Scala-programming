package CaseClassesAndPatternMatching

/**
  * Created by brahim on 3/3/18.
  */
object PatternMatching {

  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e // double negation
    case BinOp("+", e, Number(0)) => e // adding zero
    case BinOp("*", e, Number(1)) => e // multiplying by one
    case _ => expr
  }


  /*
  Wilcard patterns :
  the wildcard pattern(_) matches nay obejct whatsoever. you have
   */

  def binOperation(expr: Expr) = expr match {
    case BinOp(op, left, right) => println(expr + " is a binary operation")
    case _ =>
  }

  def binOperation2(expr: Expr) = expr match {
    case BinOp(_, _, _) => println(expr + " is a binary operation")
    case _ => println("it's something else")
  }


  /*
  Contstant patterns :
  a constant pattern matches only itsef
   */

  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi !"
    case Nil => "the emply list"
    case _ => "something else"
  }

  /*
  Variable matching
   */

  def zeroOrNot(x: Any) = x match {
    case 0 => "ZERO"
    case somethingElse => "NOT ZERO: " + somethingElse
  }


  /*
  Constructor patterns :: deep matching
   */

  def binOperationDeep(expr: Expr) = expr match {
    case BinOp("+", e, Number(0)) => println("this is a deep match")
    case _  =>
  }


  /*
  Sequence matching ::
  matching over collections (lists, arrays, maps ...)
   */

  // a list of 3 element that start with a zero

  def listOf3ElementsStartWithZero(l: List[Any]) = l match {
    case List(0, _, _) => println("the first element of this list is ZERO")
    case _ => println("the first element is not a ZERO")
  }

  def listStartsWithZero(l : List[Any]) = l match {
    case List(0,_*) => println("the first elements of this list is a ZERO")
    case _ => println("the first elements is not a zero")
  }

  /*
  Tuple patterns
   */

  def tuple(expr : Any) = expr match{
    case (a,b,c) => println("this is a tuple of 3 elements")
    case _ => println("otherwise")
  }



  /*
  Typed patterns
   */

  def generalSize(x: Any) = x match{
    case s : String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }


  def isIntMap(x: Any) = x match {
    case m : Map[Int, Int] => true
    case _ => false
  }

  def isStringArray(x: Any) = x match {
    case a : Array[String] => "Yes"
    case _ => "No"
  }


  /*
  Variable biding
   */

  def absExpression( expr: Expr) = expr match {
    case UnOp("abs", e @ UnOp("abs", _)) => e
    case _ =>
  }

  /*
  Pattern guards
   */

  def simplifyAdd(expr: Expr) = expr match {
    case BinOp("+", x, y)  if x == y =>   BinOp("*", x, Number(2))
    case _ => expr

  }


  def simplifyAll(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-",e)) => simplifyAll(e)
    case BinOp("+", e, Number(0)) => simplifyAll(e)
    case BinOp("*", e, Number(1)) => simplifyAll(e)
    case UnOp(op,e) => UnOp(op, simplifyAll(e))
    case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => expr

  }


  def describe(e: Expr): String = e match {
    case Var(_) => "a variable"
    case Number(_) => "a number"
    case _ => throw new RuntimeException
  }

  /*
  a more lightweight is to add an @unchecked annotation to
  the selector expression of the match
   */
  def describe2(e: Expr) : String = (e: @unchecked) match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }


  /*
  Case sequences as partial functions
   */

  val withDefault : Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }


  //the compiler will complain that the match is not exhaustive

  //warning: match is not exhaustive
  //missing combination Nil
  val second : List[Int] => Int = {
    case x :: y :: _ => y
  }

  val second2 : PartialFunction[List[Int], Int] = {
    case x :: y :: _ => y
  }


  /*
  Pattern for expression
   */

  def showCapitals(m : Map[String, String])  {
    for((country, capital) <- m)
      println("the capital of "+country+" is: "+ capital)
  }








}


