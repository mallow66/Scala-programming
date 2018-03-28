package Lists

/**
  * Created by brahim on 3/4/18.
  */
object Main extends App{

  val fruit = List("apples", "oranges", "pears")
  val nums = List(1, 2, 3, 4)
  val diag3 = List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )

  val empty = List()

  val fruit2 : List[String] = List("apples", "oranges", "pears")
  val num2: List[Int] = List(1, 2, 3, 4)
  val diag33: List[List[Int]] =
    List(
      List(1, 0, 0),
      List(0, 1, 0),
      List(0, 0, 1)
    )
  val empty2 : List[Nothing] = List()

    /*
    constructing lists
     */
  val fruit3 = "apples" :: "oranges" :: "pears" :: Nil
  val num3 = 1 :: 2 :: 3 :: Nil
  val empty3  = Nil

  /*
  Basic operations on lists
  head -> returns the first element of a list
  tail -> returns a list consisting of all elements expect the first
  isEmpty -> returns true if the list is empty
   */

  //insert elements in a sorted list
  def insert(x: Int, xs : List[Int]) : List[Int] =
    if(xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)

  def sort(xs : List[Int]): List[Int] =
    if(xs.isEmpty) Nil
    else insert(xs.head, sort(xs.tail))


  /*
  List patterns
   */

  val List(a, b, c) = fruit
  print(a) //apples
  println(b) // oranges
  println(c) // pears

  val x :: y :: rest = fruit
  println(x) //apples
  println(y) //oranges
  println(rest) // pears

  /*
  insert and sort written with pattern matching
   */

  def insert2(x: Int, xs : List[Int]) : List[Int] = xs match{
    case Nil => List(x)
    case y :: ys => if(x<= y) x :: y :: ys
                    else y :: insert2(x, ys)
  }

  def sort2(xs: List[Int]) : List[Int] = xs match {
    case Nil => List()
    case y :: ys => insert2(y, sort2(ys))
  }

  /*
  list concatenation
   */

  println(List(1,2,3) ::: List(4,5,6))

  def append[T](xs: List[T], ys: List[T]) : List[T] = xs match {
    case Nil => ys
    case x :: xs1 => x :: append(xs1, ys)
  }

  /*
  Taking the length of a list

   */
  println(List(1,2,3,4).length)

  /*

  On lists, unlike arrays, length is a relatively expensive operation. It needs to
traverse the whole list to find its end and therefore takes time proportional to
the number of elements in the list. That’s why it’s not a good idea to replace
a test such as xs.isEmpty by xs.length == 0 . The result of the two tests
are equivalent, but the second one is slower, in particular if the list xs is long.
   */



  /*
  Accessing the end of a list :  init and last
  init -> returns a list consisting of all elements expect the last one
  last -> returns the last element of a list
   */

  println(List('a', 'b', 'c', 'd').last) // d
  println(List('a', 'b', 'c', 'd').init) // List('a', 'b', 'c')

  /*
  reverse a list
   */

  println(List('a', 'b', 'c', 'd').reverse) // List('d', 'c', 'b', 'a')

  //reverse implementation ::

  def rev[T](xs : List[T]) : List[T] = xs match {
    case List() => List()
    case x :: xs1 => rev(xs1) ::: List(x)
  }

  /*
  Prefixes and siffixes: drop, take and splitAt
   */

  println( List(1,2,3,4) take 2 ) // List(1,2)
  println( List(1,2,3,4) take 10) // List(1,2,3,4)

  println(  List(1,2,3,4) drop 2) //List(3,4)
  println(List(1,2,3,4) drop 10) //List()

  println(List(1,2,3,4) splitAt 2 ) // (List(1,2), List(3,4))

  println( List(1,2,3,4) apply 2) // index eq to List(1,2,3,4)(2)


  /*
  Flattening a list of lists
   */

  val listOfLists = List(List(1,2), List(3), List(), List(4,5))
  println("Flatenning list" + listOfLists.flatten) // Flatenning listList(1, 2, 3, 4, 5)


  /*
  Zipping lists : zip and unzip

  the zip operations takes two lists and forms a list of pairs :
  if the two lists are of different of length, any unmatched elements are dropped
   */

  val indexes = List(0,1,2,3,4)
  val letters = List('a', 'b', 'c', 'd', 'e')
  println( indexes zip letters) //List((0,a), (1,b), (2,c), (3,d), (4,e))
  //eq to
  println( letters.indices zip letters) //List((0,a), (1,b), (2,c), (3,d), (4,e))

  val zippedletters = letters zipWithIndex ;// List((a,0), (b,1), (c,2), (d,3), (e,4))

  //unzip the list
  println(zippedletters unzip) // (List(a, b, c, d, e),List(0, 1, 2, 3, 4))

  /*
  Displaying lists : toString and mkString
   */
  val s = letters mkString("{", "-", "}")
  println(s) // {a-b-c-d-e}


  /*
  Converting lists :: iterator, toArray, copyToArray
   */

  val arr = letters.toArray //Array(a, b, c, d, e)
  val l = arr.toList //List(a, b, c, d, e)

  //iterator
  val it = letters.iterator
  println(it next) // a
  println(it next) // b


  /*
  Example : Merge sort
   */


 def msort[T](less : (T,T) => Boolean)(xs: List[T]) : List[T] = {

   def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match  {
     case(Nil, _) => ys
     case(_, Nil) => xs
     case (x::xs1, y::ys1) => if(less(x,y)) x::merge(xs1,ys)
                              else y :: merge(xs, ys1)
   }

   val n = xs.length / 2
   if(n == 0) xs
   else {
     val (ys, zs) = xs splitAt n
     merge(msort(less)(ys), msort(less)(zs) )
   }

 }

  //test msort function

  val less = (x: Int, y: Int) => x < y
  val myList = List(5,2,8,4,10,12,1,0)
  val mySortedList = msort(less)(myList)
  println(mySortedList)



/*
Maping over lists :: map, flatmap, and foreach

the operation xs map f takes as operands a list xs of type List[T]
and a function f of type T => U. it returns the resulting list from
applying the function f to each list element in xs

 */

  println( myList map (_ + 1) )  //List(6,3,9,5,11,13,2,1)


  val words = List("the", "quick", "brown", "fox")
  println( words map (_.length) ) // List(3, 5, 5, 3)

  println( words map (_.toList.reverse.mkString ) ) //List(eht, kciuq, nworb, xof)

  /*
  flatMap takes a function returning a list of elements as its
  right operand. it applies the function to each list element
  and returns the concatenation of all function results
  here is an example that illustrates the difference between map and flatMap
   */

  println( words map (_.toList)) //List(List(t, h, e), List(q, u, i,c, k), List(b, r, o, w, n), List(f, o, x))

  println(words flatMap(_.toList)) //List(t, h, e, q, u, i, c, k, b, r, o, w,n, f, o, x)


  println( List.range(1,5) flatMap( i => List.range(1,i) map (j => (i,j))))
  // List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))

  for (i <- List.range(1,5); j <- List.range(1,i) ) yield (i, j)


  /*
  foreach takes a procedure( a function with result tye Unit) as a
  right operand. it applies the procedure to each list element
  the result of the operation itself is again Unit; lo list of
  results is assembled.
   */

  var sum = 0
  List(1, 2, 3, 4, 5) foreach(i => sum += i)
  println(sum)
  //or just
  List (1, 2, 3, 4, 5) foreach (sum += _)


  /*
  Filterin lists :: filter, partition, find, takeWhile, dropWhile, span
   */

  println( List (1, 2, 3, 4, 5) filter ( _ %2 == 0 ) ) // List(2, 4)


  /*
  the partition method is like filter, but it returns a pair of lists
  One list contains all elements for which the predicate is true,
  while the other list contains all elements for which the predicate is false

   --> xs partition p  equals (xs filter p , xs filter(!p(_)))
   */

  println( List (1, 2, 3, 4, 5) partition(_ % 2 == 0))  // (List(2, 4),List(1, 3, 5))


  /*
  the `find ` method returns returns the first element satisfying a given predicate
   */

  println( List (1, 2, 3, 4, 5) find( _ % 2 == 0) ) //Some(2)

  println( List (1, 2, 3, 4, 5) find (_ <= 0)) //None


  /*
  takeWhile, dropWhile operators also take a predicate as their
  right operand.
  --> xs takeWhile p takes the longest prefix of list xs such that
  every element in the prefix satisfies p
  ---> xs dropWhile p drop the longest prefix from xs such that every
  element in the prefix satisfies p
   */


  println( List (1, 2, 3, -4, 5) takeWhile (_ > 0)) // List(1, 2, 3, 5)

  println( words dropWhile ( _ startsWith "t")) //List(quick, brown, fox)

  /*
  span method combines takeWhile and dropWhile in one operation
  It returns a pair of two lists defined by ::

   --> xs span p equals ( xs takeWhile p, xs dropWhile p )

   */

  println( List(1, 2, 3, -4, 5) span (_ > 0 ))


  /*
  predicates over lists: forall and exists
   --> forall returns true if all elements in the list satisfy p.
   --> exists returns true if the there is an element in the list that satisfy
   the predicate
   */

  def hasZeroRow(m: List[List[Int]]) = m exists(row => row forall (_ == 0))

  /*
  Folding lists /: and :\

  a fold left operation "(x /: xs) (op)" involves three objects:
  a start value z, a list xs, and a binary operation op.
  The result of the fold is op applied between successive elements of the
  list prefixed by z. For instance:
  ( z /: List(a, b, c) ) (op) equals  op(op(op(z,a),b),c)
   */

  def sum(xs: List[Int]): Int = (0 /: xs)(_ + _)
  def product(xs: List[Int]): Int = (1 /: xs)(_ * _)



  def concatenate(xs : List[String]) = ("" /: xs)(_ +" "+ _)
  //this give an extra space in the beginning. we can remove the
  //space by using this version

  def concatenate2(xs : List[String]) = (xs.head /: xs.tail)(_ +" "+ _)

  /*
  the /: operator produces left-leaning operation trees
  the :\ operator produces right-leaning operation trees

  --> (List(a, b, c) :\ z)(op) equals op(a, op(b, op(c, z)))
   */


  //def flattenLeft[T](xss : List[List[T]]) = (List[T]() /: xss)(_ ::: _)
  //def flattenRight[T](xss : List[List[T]]) = (xss :\ List[T]())(_ ::: _)


  def reverseLeft[T](xs: List[T]) = (List[T]() /: xs) {(ys, y) => y :: ys}


  println( reverseLeft(List(1,2,3,4)))


  /*
  Sorting lists :: sortWith
   */

  println( List(1, -3, 10, 2, 8) sortWith(_ < _))
  println( words sortWith(_.length > _.length))




  /*
  Methods of the list object
   */

  // List.apply
  println( List.apply(1, 2, 3)) // List(1, 2, 3)

  //List.range
  println(List.range(1,5)) //List(1, 2, 3, 4)

  println( List.range(1,9,2)) //List(1, 3, 5, 7)


  //List.fill
  println(List.fill(5)('a')) //List(a, a, a, a, a)

  println( List.fill(2, 3)('b')) // List( List(b, b, b), List(b, b, b) )

  /*
  List.tabulate
  creates a list whose elements are computed according to a supplied
  function.
   */
   val squares = List.tabulate(5)(n => n*n)
  println( squares ) // List(0, 1, 4, 9, 16)

  val multiplication = List.tabulate(5,5)(_ * _ )
  println( multiplication ) // List(List(0, 0, 0, 0, 0), List(0, 1, 2, 3, 4), List(0, 2, 4, 6, 8), List(0, 3, 6, 9, 12), List(0, 4, 8, 12, 16))


  //List.concat()

  println( List.concat( List(1,2), List(2,2), Nil ))

  /*
  Processing multiple lists together

   --> 'zipped' method  generalizes serveral common operations
   to work on multiple lists instead of  just one.

   ex: the map method for two zipped lists maps pairs of elements rather than
   individual element of each list
   */

  println((List(10,20), List(3,4,5)).zipped.map((x,y) => x * y)) // List(30,80)



}



