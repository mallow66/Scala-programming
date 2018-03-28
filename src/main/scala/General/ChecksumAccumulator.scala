package General

/**
  * Created by brahim on 2/21/18.
  */
class ChecksumAccumulator {

  private var sum = 0

  def add(b : Byte) : Unit = sum+=b
  def checksum() : Int = ~(sum & 0xFF) + 1

}



/*
The singleton object in this figure is named General.ChecksumAccumulator , the
same name as the class in the previous example. When a singleton object
shares the same name with a class, it is called that class’s companion object.
 */
import scala.collection.mutable.Map
object ChecksumAccumulator {

  private var cache = Map[String, Int]()


  def calculate(s: String): Int = {
    if(cache.contains(s))
      cache(s)
    else{
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)

      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
  }


}

