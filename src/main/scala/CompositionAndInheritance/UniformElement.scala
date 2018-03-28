package CompositionAndInheritance

/**
  * Created by brahim on 2/26/18.
  */
class UniformElement(
                    ch : Char,
                    override val width : Int,
                    override val height : Int
                    ) extends Element{
  private val line = ch.toString * width

  override def contents = Array.fill(height)(line)
}


