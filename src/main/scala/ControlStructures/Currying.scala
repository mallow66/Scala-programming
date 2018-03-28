package ControlStructures

/**
  * Created by brahim on 2/23/18.
  */
class Currying extends App{


  def plainOldSum(x : Int, y : Int)  = x + y

  /*
  A curried function is applied to multiple argument lists,
  instead of just one.
   */



  def curriedSum(x : Int)(y : Int) = x + y

  /*
  Here is a function named first that does in spirit what the first
  tradional function invocation of curriedSum would do :
   */

  def first(x : Int) = (y : Int) => x+y

  val second = first(1) // second: (Int) => Int = <function1>

  println(second(2)) // Int = 3

}
