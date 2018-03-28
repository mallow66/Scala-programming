package General

import scala.io.Source

/**
  * Created by brahim on 2/28/18.
  */
object ReadFromFiles {

  def main(args : Array[String]) : Unit = {

    for(line <- Source.fromFile("data.csv").getLines() )
      println(line.length+ "    "+ line)

  }

}
