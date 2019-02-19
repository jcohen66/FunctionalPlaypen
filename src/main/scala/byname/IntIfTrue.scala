package byname

object IntIfTrue extends App {

  /**
    * Break inputs into two compartments with
    * implicit as rightmost argument.
    *
    * @param a
    * @param b  implicit
    */
  def printIntIfTrue(a: Int)(implicit b: Boolean) = if(b) println(a)

  implicit val b = true

  printIntIfTrue(42)(true)
  printIntIfTrue(42)
}
