package Traits

/**
  * Created by brahim on 2/28/18.
  */
trait Rectangular {

  def topLeft : Point
  def bottomRight : Point

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}
