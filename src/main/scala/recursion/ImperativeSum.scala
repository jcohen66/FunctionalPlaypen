package recursion

object ImperativeSum extends App {

  def sum(xs: List[Int]): Int = {

    var sum = 0
    for { i <- xs } {
      sum += i
    }
    sum
  }

  def test(max: Int) {
    val max = 10000
    val startTime = System.nanoTime()
    val list = List.range(1, max)
    val endTime = System.nanoTime()
    println("Imperative: " + sum(list) + " in " + (endTime - startTime) + " nanos")
  }
}
