package Collections

import scala.collection.mutable

/**
  * Created by brahim on 3/17/18.
  */
object SetsAndMaps extends App{


  /*
  Sets :
  the characteristic of sets is that they will ensure that at most one
  of each object as determined by ==, will be contained in the set at any one time

   */

  val text = "See Spot run. Run, Spot. Run!"
  val wordsArray = text.split("[ !,.]+")
  wordsArray.foreach(println) // See Spot run Run Spot Run

  /*
  to count the distinct words, you can convert them to the same case and
  add them to a set
   */


  val words  = mutable.Set.empty[String]
  for(word <- wordsArray) words += word.toLowerCase

  println("The distinct objects are :")
  words.foreach(println)



  /*
  Maps :: let you associate a value with each element of the collection
  Using a map looks similar to using an array, except that instead of indexing with
  intergers counting from 0, you can use any kind of key
   */

  val map = mutable.Map.empty[String, Int]

  map("hello") = 1 // hello is the key
  map("there") = 2 // 2 is the value


  def countWords(text: String): mutable.Map[String, Int] = {
    val counts = mutable.Map.empty[String, Int]
    for(rawWord <- text.split("[ ,!.]+")){
      val word = rawWord.toLowerCase
      val oldCount =
        if (counts.contains(word)) counts(word)
        else 0
      counts += (word -> (oldCount + 1))
    }
    counts
  }

  val res = countWords("See Spot run! Run, Spot. Run!")
  println( res ) // Map(spot -> 2, see -> 1, run -> 3)

  /*
  Common operations for maps
   */

  val nums = Map("i"->1, "ii" -> 2) // creates a map

  nums + ("iv" -> 4) // adds an entry

  nums - ("ii") // removes an entry

  nums ++ List("iii"->3, "v"->5) // add multiple entries

  nums -- List("i", "ii") // removes multiple entries

  nums.size   // returns the sizeof the map

  nums.contains("ii") // checks for inclusion

  nums("iv") //retrieves the value of the specified key

  nums.keys // returns an Iterable of keys
  nums.keySet  // returns keys as set

  nums.values // returns the values as an Iterable
  nums.isEmpty   // checks if the map is empty
}
