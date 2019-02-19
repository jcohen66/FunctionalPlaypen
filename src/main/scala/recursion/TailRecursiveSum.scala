package recursion

import scala.annotation.tailrec

/**
  * Problem statement:
  *
  * If the sum function is given an empty list of integers, it should
  * return 0 because the sum of nothing is 0.
  *
  * Otherwise, if the list is not empty, the sum of the head element plus
  * the sum of the tail elements.
  *
  *
  */
object TailRecursiveSum extends App {

  /**
    * This is the public API.
    *
    * @param list
    * @return
    */
  def sum(list: List[Int]): Int = {

    /**
      * This is the private API with the intermediate calculations
      *
      * @param list
      * @param accumulator
      * @return
      */
    @tailrec
    def sumWithAccumulator(list: List[Int], accumulator: Int): Int = {
      list match {
        case Nil => {
          //println("case1: Nil was matched")
          accumulator
        }
        case head :: tail => {
          //println(s"case2: head = $head, tail = $tail")
          sumWithAccumulator(tail, accumulator + head)
        }
      }
    }

    sumWithAccumulator(list, 0)
  }

  def test(max: Int) {
    val startTime = System.nanoTime()
    val list = List.range(1, max)
    val endTime = System.nanoTime()
    println("Recursive: " + sum(list) + " in " + (endTime - startTime) + " nanos")
  }

  val max = 1000000

  TailRecursiveSum.test(max)
}
