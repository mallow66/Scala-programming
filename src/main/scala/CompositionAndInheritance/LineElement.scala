package CompositionAndInheritance

/**
  * Created by brahim on 2/26/18.
  */
class LineElement(s : String) extends Element{
  def contents = Array(s)
  override def width = s.length
  override def height = 1

  override def demo(): Unit ={
    println("LineElement's implementation invoked")
  }


}
