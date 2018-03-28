package PackagesAndImports
package bobsdelights


/**
  * Created by brahim on 3/1/18.
  */
object Fruits {
  object Apple extends Fruit("apple", "red")
  object Orange extends Fruit("orange", "orange")
  object Pear extends Fruit("pear", "yellowish")

  val menu = List(Apple, Orange, Pear)

}
