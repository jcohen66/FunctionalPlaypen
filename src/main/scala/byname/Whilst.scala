package byname

object Whilst extends App {

  /**
    * Break the inputs into two compartments.
    *
    * @param testCondition
    * @param codeBlock
    */
  def whilst(testCondition: => Boolean)(codeBlock: => Unit): Unit = {
    while(testCondition) {
      codeBlock
    }
  }

  var i = 1
  whilst(i < 5) {
    println(i)
    i += 1
  }

}
