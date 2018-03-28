package Traits

/**
  * Created by brahim on 2/28/18.
  */
object Main {

  def main(args : Array[String]): Unit ={

    val frog = new Frog
    println(frog)

    frog.philosophize()

    /*
    A trait also defines a type. Thus, we can use Philosophical
    as a type
     */

    /*
    Thus, variable phil could have
    been initialized with any object whose class mixes in Philosophical .
     */

    val phil : Philosophical = frog
    phil.philosophize()



    val phrog : Philosophical = new Frog2
    phrog.philosophize


    val rect = new Rectangle(new Point(1,1), new Point(10,10))
    println(rect.left)
    println(rect.right)

    /*
    the ordered trait
    now that we implemented compare method in Rational class
    we can use the natural Order to compare two rationals
     */

    val half = new Rational(1, 2)
    val third = new Rational(1,3)
    println( half > third)


    val queue = new BasicIntQueue
    queue.put(10)
    queue.put(20)
    println(queue.get)
    println(queue.get())


    val doublingQueue  = new DoublingQueue
    doublingQueue.put(30)
    println(doublingQueue.get)


    val doublingQueue2 = new BasicIntQueue with  Doubling
    doublingQueue2.put(33)
    println(doublingQueue2.get())

    /*
    The order of mixins is significant :
     */
    val filteringAndIncrementingQueue = new BasicIntQueue with Incrementing with Fittering

    filteringAndIncrementingQueue.put(-1)
    filteringAndIncrementingQueue.put(0)
    filteringAndIncrementingQueue.put(1)

    println(filteringAndIncrementingQueue.get)
    println(filteringAndIncrementingQueue.get)

  }

}
