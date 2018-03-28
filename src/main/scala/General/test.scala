package General

/**
  * Created by brahim on 2/28/18.
  */
object test {
  def main(args : Array[String]): Unit ={

    //create a list

    var myList : List[Int] = List(1,3,3,4,9,4,0,2)
    myList.foreach( n => println( "element : "+ n))
    var stringList  = List("rabat", "bouznika", "casablanca", "tanger")

    println(stringList.filter(s => s.length>6))
    println(stringList.init)



    /*
    If we want a mutable Set we should use an import
    import scala.collection.mutable.Set
     */
    var jetSet = Set("Airbus", "Boeing")
    println(jetSet)
    jetSet += "Lear"
    println(jetSet.contains("SpaceX"))

    import scala.collection.immutable.HashSet
    val hashSet = HashSet("Tomatoes", "Chilies")
    println(hashSet + "Coriander")


    import scala.collection.mutable.Map
    val treasureMap = Map[Int, String]()
    treasureMap += (1 -> "Go to island")
    treasureMap += (2 -> "Find big X on ground")
    treasureMap += (3 ->"Dig")
    println(treasureMap(2))


  }

}
