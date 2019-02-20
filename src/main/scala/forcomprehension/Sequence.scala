package forcomprehension

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer



/**
  * Sequence constructor will have one parameter, and
  * that parameter can be assigned to a variable number
  * of elements.
  *
  * @param initialElems
  * @tparam A
  */
case class Sequence[A](initialElems: A*) {

  private val elems = scala.collection.mutable.ArrayBuffer[A]()

  /**
    * Implement withFilter() to enable for { i <- ints if i > 2 } yield i*2 expression
    *
    * @param p
    * @return
    */
  def withFilter(p: A => Boolean): Sequence[A] = {
    val tmpArrayBuffer = elems.filter(p)
    Sequence(tmpArrayBuffer: _*)
  }

  /**
    * Implement map() to enable for { i <- ints } yield i*2 expression
    *
    * @param f
    * @tparam B
    * @return
    */
  def map[B](f: A => B): Sequence[B] = {
    val abMap: ArrayBuffer[B] = elems.map(f)
    // create a new Sequence and return it.
    Sequence(abMap: _*)
  }

  /**
    * Implement flatMap to enable multiple generators in a for/yield expression.
    *
    * @param f
    * @tparam B
    * @return
    */
  def flatMap[B](f: A => Sequence[B]): Sequence[B] = {
    val mapRes: Sequence[Sequence[B]] = map(f)    // map
    flattenLike(mapRes)                               // flatten
  }

  /**
    * Converts a List of Lists into a single List
    *
    * @param seqOfSeq
    * @tparam B
    * @return
    */
  def flattenLike[B](seqOfSeq: Sequence[Sequence[B]]): Sequence[B] = {
    var xs = ArrayBuffer[B]()
    for (listB: Sequence[B] <- seqOfSeq) {
      for (e <- listB) {
        xs += e
      }
    }
    Sequence(xs: _*)
  }

  /**
    * Implement foreach to enable the for (i <- ints) println(i)
    *
    * @param block
    */
  def foreach(block: A => Unit) = {

    // elems.foreach(block)

    @tailrec
    def loop(b: A => Unit, arr: List[A]): Unit = {
      arr match {
        case Nil =>
        case head :: tail => {
          b(head)
          loop(b, tail)
        }
      }
    }

    loop(block, elems.toList)
  }

  // ***********
  // Constructor
  // ***********

  // initialize
  elems ++= initialElems

  /*
  The above line is equivalent to:

  for {
    e <- initialElems
  } elems += e

   */
}

object Sequence extends App {

  case class Person(name: String)

  val strings = Sequence("one", "two", "three")
  val nums = Sequence(1, 2, 3, 4, 5)

  println(strings)
  println(nums)

  // works because foreach() is defined
  for (i <- nums) println(i)

  // works because map() is defined
  for {
    i <- nums
  } yield i*2

  // works because withFilter() is defined
  val res = for {
    i <- nums
    if i > 2
  } yield i * 2

  val ints = Sequence(1,2,3,4,5).withFilter(_ > 2)

  val myFriends = Sequence(
    Person("Adam"),
    Person("David"),
    Person("Frank")
  )

  val adamsFriends = Sequence(
    Person("Nick"),
    Person("David"),
    Person("Frank")
  )

  val mutualFriends = for {
    myFriend <- myFriends         // generator
    adamsFriend <- adamsFriends   // generator
    if (myFriend.name == adamsFriend.name)
  } yield myFriend
  mutualFriends.foreach(println)

}
