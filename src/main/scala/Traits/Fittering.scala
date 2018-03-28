package Traits

/**
  * Created by brahim on 3/1/18.
  */
trait Fittering extends IntQueue{

  abstract override def put(x: Int): Unit = if (x>=0) super.put(x)
}
