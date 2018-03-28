package General

import FunctionalObjects.Rational

/**
  * Created by brahim on 2/14/18.
  */
object  ExampleApp extends App {

  println("Hello world !! ") ;

  val r = new Rational(1,2)

  //println(r.add(new Rational(2,4)))
  //println(r.+(new Rational(2,4)))

  //implicit conversion to make int + Rational works
  implicit  def intToRational(x : Int) = new Rational(x)
 // println( (2 + new Rational(2,4)))

  println(new Rational(66,42))

}
