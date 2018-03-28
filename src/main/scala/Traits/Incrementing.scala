package Traits

/**
  * Created by brahim on 3/1/18.
  */
trait Incrementing extends IntQueue{

  abstract override def put(x: Int): Unit = super.put(x+1)
}
