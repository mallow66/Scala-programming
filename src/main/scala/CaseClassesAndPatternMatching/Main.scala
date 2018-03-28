package CaseClassesAndPatternMatching

/**
  * Created by brahim on 3/3/18.
  */
object Main extends App{

  val v = Var("x")
  //the fields name is implicitly created
  println(v.name)


  val op = BinOp("+", Number(1), v)

  println("left of op:: "+ op.left)
  println("right of op:: " + op.right)

  //compare is implemented impicitely
  println(op.right == Var("x"))


  //the copy method
  val opCopy = op.copy(operator = "-")
  println(opCopy)


  import PatternMatching._
  println(describe(5))



  println(generalSize("abc") )
  println(generalSize(Map(1->'a', 2->'b')))
  println(generalSize(math.Pi))


  /*
  Patterns in variable definitions
   */

  val myTuple = ("123", "abc")
  val (number, string) = myTuple


  val expr = new BinOp("*", Number(5), Number(1))
  val BinOp(p, l, r) = expr // p = * , l = Number(5) , r = Number(1)

  println(withDefault(Some(10))) // 10
  println(withDefault(None)) // 0



  println(second(List(1,2,3)))
  //println(second( List() ))

  /*
  Partial functions have a method isDefinedAt, which can be used to test
  whether the function is defined at a particular value.
  In this case, the function is defined for any list that has
  at least two elements
   */

  println(second2.isDefinedAt(List(1,2))) // true
  println(second2.isDefinedAt(List(1,3,4))) // true
  println(second2.isDefinedAt(List(1))) // false
  println(second2.isDefinedAt(List()))



  val capitals = Map("Morocco" -> "Rabat", "France" -> "Paris", "Japan" -> "Tokyo")
  showCapitals(capitals)
}
