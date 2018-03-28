package Traits

/**
  * Created by brahim on 2/28/18.
  */
class Frog2 extends Animal with Philosophical with  HasLegs{
  override def toString  = "green"

  /*
  Frog2 has inherited an implementation of philosophize from
  trait Philosophical.
  Frog2 could also override philosophize :
   */
  override def philosophize(): Unit ={
    println("It ain't easy being "+ toString+"!")
  }


}
