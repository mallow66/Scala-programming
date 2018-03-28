package ControlStructures

import java.io.PrintWriter
import java.io._


/**
  * Created by brahim on 2/24/18.
  */
object Examples extends App{

  def twice (op  : Double=>Double, x : Double) = op(op(x))

  println(twice (_ + 1, 5)) // Double = 7.0


  def withPrintWriter( file : File, op : PrintWriter => Unit ): Unit ={
    val writer = new PrintWriter(file)

    try{
      op(writer)
    } finally {
      writer.close()
    }
  }

  //exec
  withPrintWriter(new File("data.csv"), writer => writer.println(new java.util.Date))


}
