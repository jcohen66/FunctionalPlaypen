package byname

object ByNameTests extends App {

  var assertionsEnabled = true

  // function input parameter
  def myAssert(p: () => Boolean) =
    if (assertionsEnabled && !p())
      throw new AssertionError


  myAssert(() => 5 > 3)

  // By-Name input parameter
  def byNameAssert(p: => Boolean) =
    if (assertionsEnabled && !p)
      throw new AssertionError
}