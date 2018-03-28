package General

/**
  * Created by brahim on 2/23/18.
  */
object Functions extends App{


  var increase = (x : Int) => x +1
  println(increase(10)) // shows 11

  /*
  Increase in the example above is a var, so you can change it
   */

  increase = (x : Int) => x + 80
  println(increase(10)) // shows 90

  /*
  We can also add many statement in the function literal
   */

  increase = (x : Int) => {
    println("Hello !")
    println("I am here !")
    x + 1

  }

  /*
  Function literals can be used in many libraries. For example foreach
   */

  val numbers = List(-11, -10, -5, 0, 5, 10)
  numbers.foreach((x : Int) => println(x))

    /*
    the statement above can be written also like this :
     */

  numbers.foreach(x => println(x))

  /*
  Placeholder syntax :
  we make the syntax more concise, by using the underscores as
  placeholders for one or more parameters
   */

  numbers.filter( x => x>0)
  /*
  Equavalent to
   */
  numbers.filter(_ > 0)


  /*
  we can also use placeholder syntax to specify the types like this :
   */

  val f = (_ : Int) + (_ : Int)
  println("the sum of 3 and 7 is : "+ f(3,7))



  /*
  Partially applied functions

  we can also replace an entire parameter list with an underscore/
   */

  numbers.foreach(println _ )
  /*
  Equivalent to  :
   */
  numbers.foreach(x => println(x))

  /*
  Another example: is when you define a function and you try to re use it
   */
  def sum(a : Int, b : Int) = a + b

  /*
  f1 refers to the the function value sum
   */
  val f1 = sum _

  println(f1.apply(1,2))
  println(f1(1,2))

  /*
  We can also express a parially applied function by supplying some
  but not all the arguments.
   */
  val f2 = sum(1, _ :Int )
  println(f2(4))





}
