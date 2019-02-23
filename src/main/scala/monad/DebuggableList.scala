package monad

/**
  * Implementation of Writer Monad from Haskell
  *
  * @param value
  * @param log
  */
case class DebuggableList (value: Int, log: List[String]) {

  def map(f: Int => Int): DebuggableList = {
    val newValue = f(this.value)
    DebuggableList(newValue, this.log)
  }

  def flatMap(f: Int => DebuggableList): DebuggableList = {
    val nextValue: DebuggableList = f(value)
    DebuggableList(nextValue.value, this.log ::: nextValue.log)
  }

}

object TesterList extends App {

  def f(a: Int): DebuggableList = {
    val result = a * 2
    val message = s"f: a ($a) * 2 = $result "
    DebuggableList(result, List(s"f: multiply $a * 2 = $result"))
  }

  def g(a: Int): DebuggableList = {
    val result = a * 3
    val message = s"g: a ($a) * 3 = $result "
    DebuggableList(result, List(s"g: multiply $a * 3 = $result"))  }

  def h(a: Int): DebuggableList = {
    val result = a * 4
    val message = s"h: a ($a) * 4 = $result"
    DebuggableList(result, List(s"h: multiply $a * 4 = $result"))  }

  val finalResult = for {
    fResult <- f(100)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield hResult

  finalResult.log.foreach(l => println(s"LOG: $l)"))
  println(s"Output is: ${finalResult.value}")
}