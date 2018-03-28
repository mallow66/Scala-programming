package Collections

/**
  * Created by brahim on 3/17/18.
  */
object Tuples extends App{

  /*
  Tuples ::
  combines a fixed number of items together. Unlike an array of list,
  a tuple can hold objects with different types
   */

  def longestWord(words: Array[String]) = {
    var word = words(0)
    var idx = 0
    for(i<- 1 until words.length)
      if(words(i).length > word.length){
        word = words(i)
        idx = i
      }
    (word, idx)
  }

  //example
  val longest = longestWord("My name is brahim and I write Scala code".split(" "))
  println( longest) // (brahim, 3)

  //to access elements of a tuple, we can use _1, _2, ...
  println(longest._1) // brahim
  println(longest._2)   // 3

  // we can assign each element of the tuple to its variable

  val (word, idx) = longest
  println( word) // brahim
  println(idx) // 3

  // By the way if we leave off the parentheses, we'll get a
  //different result

  val a, b = longest
  println(a) // (brahim, 3)
  println( b) // (brahim, 3)

}
