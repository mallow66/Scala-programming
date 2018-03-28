package CaseClassesAndPatternMatching

/**
  * Created by brahim on 3/3/18.
  */
object OptionType extends App {

  val capitals = Map("Morocco" -> "Rabat","France" -> "Paris", "Japan" -> "Tokyo")
  println(capitals get "France" )// the result is a type of Option[java.lang.String] Some(Paris)

  println(capitals get "USA") // the result is a type of Option[java.lang.String] None


  def show(x : Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }


  println(show (capitals get "UK" ))
  println( show (capitals get "Morocco"))
}
