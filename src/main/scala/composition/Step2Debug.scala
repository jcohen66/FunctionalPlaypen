package composition

object Step2Debug extends App {
  def f(a: Int): (Int, String) = {
    val result = a * 2
    (result, s"\nf result: $result.")
  }

  def g(a: Int): (Int, String) = {
    val result = a * 3
    (result, s"\ng result: $result.")
  }

  // get the output of 'f'
  val (fInt, fString) = f(100)

  // plug the Int from 'f' as the input to 'g'
  val (gInt, gString) = g(fInt)

  // create the total "debug string" by manually merging
  // the strings from f and g
  val debug = fString + " " + gString
  println(s"result: $gInt, debug: $debug")

}
