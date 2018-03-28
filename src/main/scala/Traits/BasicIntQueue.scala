package Traits

import scala.collection.mutable.ArrayBuffer

/**
  * Created by brahim on 3/1/18.
  */
class BasicIntQueue extends IntQueue{

  private val buf = new ArrayBuffer[Int]()

  def get = buf.remove(0)
  def put(x:Int) : Unit =  buf += x
}
