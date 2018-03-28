package AssertionsAndUnitTesting

/**
  * Created by brahim on 3/1/18.
  */
object Main extends App{


  assert(1 == 0) // false


  def sum(a: Int, b: Int) = a + b ensuring(a>0 && b>0)

}
