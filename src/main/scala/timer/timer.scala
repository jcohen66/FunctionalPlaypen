package timer

object timer extends App {

  /**
    * Uses a by-name parameter to take in a
    * block of code and execute it.
    *
    * @param blockOfCode
    * @tparam A
    * @return
    */
  def timer[A](blockOfCode: => A) = {
    val startTime = System.nanoTime()
    val result = blockOfCode
    val stopTime = System.nanoTime()
    val delta = stopTime - startTime
    (result, delta/1000000d)
  }

  val (result, time) = timer {
    Thread.sleep(1000)
    42
  }

  println(s"Result: $result")
  println(s"Time: $time")
}
