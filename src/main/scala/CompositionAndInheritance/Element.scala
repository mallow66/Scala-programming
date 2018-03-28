package CompositionAndInheritance

/**
  * Created by brahim on 2/25/18.
  */
abstract  class Element {

  //an abstract function
  def contents : Array[String]

  def height : Int = contents.length
  def width : Int = if(height == 0) 0 else contents(0).length

  def demo(): Unit = {
    println("Element's implementation invoked")
  }

  /*
  Such parameterless methods are quite common in Scala. By contrast, meth-
ods defined with empty parentheses, such as def height(): Int , are called
empty-paren methods. The recommended convention is to use a parame-
terless method whenever there are no parameters and the method accesses
mutable state only by reading fields of the containing object (in particular, it
does not change mutable state).
   */


  /*
  To summarize, it is encouraged style in Scala to define methods that take no
parameters and have no side effects as parameterless methods, i.e., leaving
off the empty parentheses. On the other hand, you should never define a
ethod that has side-effects without parentheses, because then invocations
of that method would look like a field selection. So your clients might be
surprised to see the side effects. Similarly, whenever you invoke a function
that has side effects, be sure to include the empty parentheses when you
write the invocation.
   */

  def above(that : Element) : Element = Element.elem(this.contents ++ that.contents)

  def beside(that : Element) : Element = Element.elem (
    for (
      (line1, line2) <- this.contents zip that.contents
    ) yield line1 + line2
  )

  override def toString = contents mkString "\n"


  def widen (w: Int) : Element =
    if(w <= width) this
    else {
      val left = Element.elem(' ', (w - width)/2, height)
      val right = Element.elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten (h : Int) : Element =
    if( h <= height ) this
    else {
      val top = Element.elem(' ', width, (h - height) / 2)
      var bot = Element.elem(' ', width, h - height - top.height)
      top above this above bot
    }



}

object Element {

  def elem(contents : Array[String]) : Element  = new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int) : Element  =
    new UniformElement(chr, width, height)

  def elem(line : String) : Element =
    new LineElement(line)
}
