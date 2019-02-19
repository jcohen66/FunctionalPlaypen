package recursion

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
object RecursiveSum extends App {

  def sum(list: List[Int]): Int = list match {
      case Nil => {
        println("case1: Nil was matched")
        0
      }
      case head :: tail => {
        println(s"case2: head = $head, tail = $tail")
        head + sum(tail)
      }
    }


  def test(max: Int) {
    val startTime = System.nanoTime()
    val list = List.range(1, max)
    val endTime = System.nanoTime()
    println("Recursive: " + sum(list) + " in " + (endTime - startTime) + " nanos")
  }

  val max = 10
  ImperativeSum.test(max)
  RecursiveSum.test(max)
}
