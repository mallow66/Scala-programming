package Traits

/**
  * Created by brahim on 3/1/18.
  */
trait Doubling extends IntQueue{

  override abstract def put(x: Int) {super.put(2*x)}


}
