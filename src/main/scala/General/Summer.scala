package General

import General.ChecksumAccumulator.calculate

/**
  * Created by brahim on 2/28/18.
  */
object Summer {

  def main(args : Array[String]) : Unit = {

    var tab = Array("Rabat", "Casablanca", "Tanger")
    for (arg <- tab)
      println(arg+" : "+ calculate(arg))
  }

}
