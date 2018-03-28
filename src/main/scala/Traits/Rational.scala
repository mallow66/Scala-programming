package Traits

/**
  * Created by brahim on 3/1/18.
  */

class Rational(n : Int, d: Int) extends Ordered[Rational]{
  //checking preconditions
  require(d != 0)

  private val  g = gcd(n.abs, d.abs)
  val numer : Int = n / g
  val denom : Int = d / g

  //auxiliary constructor
  def this(n : Int) = this(n,1)

  override def toString: String = numer+"/"+denom

  /* def add(that : Rational): Rational =
     new Rational(numer* that.denom + that.numer*denom, denom * that.denom) */

  def + (that : Rational) : Rational =
    new Rational(numer* that.denom + that.numer*denom, denom * that.denom)

  //method overloading
  def + (i : Int) : Rational =
    new Rational(numer + i*denom, denom)

  def - (that : Rational) : Rational =
    new Rational(numer* that.denom - that.numer*denom, denom * that.denom)

  def - (i : Int) : Rational =
    new Rational(numer + i*denom, denom)



  def * (that : Rational) : Rational =
    new Rational(numer * that.numer , denom * that.denom)

  def * (i : Int) : Rational =
    new Rational(numer * i  , denom)

  def / (that : Rational) : Rational =
    new Rational(numer * that.denom , denom * that.numer)

  def / (i : Int) : Rational =
    new Rational(numer, denom * i)



  def lessThan(that : Rational) : Boolean =
    this.numer * that.denom < that.numer * this.denom

  def max(that : Rational) : Rational =
    if(this.lessThan(that)) that else this

  def gcd(a : Int, b : Int): Int =
    if(b==0) a else gcd(b, a % b)


  /* def < (that : Rational) =
     this.numer * that.denom > that.numer * this.denom
   def > (that: Rational) = that < this
   def <= (that: Rational) = (this< that) || (this == that)
   def >= (that: Rational) = (this>that) || (this == that)
   */

  /*
  we can use the trait Ordered. To use it we replace all of the
  individual comparison methods with a single `compare` method
   */

  def compare(that: Rational) =
    (this.numer * that.denom) - (that.numer * this.denom)
}


