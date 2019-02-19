package byname

object BothTrue extends App {

  /**
    * Break the inputs into three compartments with
    * the codeBlock being the rightmost.
    *
    * @param testCondition1
    * @param testCondition2
    * @param codeBlock
    * @return
    */
  def ifBothTrue(testCondition1: => Boolean)(testCondition2: => Boolean)(codeBlock: => Unit): Boolean = {
    if(testCondition1 && testCondition2) {
      codeBlock
      true
    } else {
      false
    }

  }

  def action() = println("Discount!")

  var age = 2
  var numAccidents = 0

  ifBothTrue(age > 18)(numAccidents == 0)(action)
}