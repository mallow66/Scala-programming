package Collections

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * Created by brahim on 3/15/18.
  */
object Sequences extends App{

  /*
  Sequences are types that let you work with groups of data lined
  up in order like : Lists, Arrays, List buffers ...
   */

  val colors = List("red", "blue", "green")
  println(colors head)  // red
  println( colors tail )

  val fiveInts = new Array[Int](5) // Array(0, 0, 0, 0, 0)
  val finToOne = Array(5,4,3,2,1)


  /*
  List buffers :: ListBuffer is a mutable object which can build
  lists more efficiently when you need to append
  we can append elements with  += operator, and prepend them with +=: operator
  When we are done building, we can obtain a List by invoking toList
  on the ListBuffer.
   */

  val buf = new ListBuffer[Int]
  buf += 1 // ListBuffer(1)
  buf += 2 // ListBuffer(1, 2)
  3 +=: buf // ListBuffer(3, 1, 2)
  println( buf toList)   // List(3, 1, 2)

  /*
  Another reason to use ListBuffer instead of List is to prevent
  the potential for stack overflow.
   */


  /*
  Array buffers ::
  An ArrayBuffer is like an array except that you can additionaly add and remove elements
  from the beginning and the end of the sequence
   */

  val buffer = new ArrayBuffer[Int]()

  //append to an arraybuffer
  buffer += 12
  buffer += 15
  println( buffer ) // ArrayBuffer(12, 15)







}
