package monad

case class Debuggable (value: Int, message: String) {

  def map(f: Int => Int): Debuggable = {
    val newValue = f(this.value)
    Debuggable(newValue, this.message)
  }

  def flatMap(f: Int => Debuggable): Debuggable = {
    val nextValue: Debuggable = f(value)
    Debuggable(nextValue.value, message + nextValue.message)
  }

}

object Tester extends App {

  def f(a: Int): Debuggable = {
    val result = a * 2
    val message = s"f: a ($a) * 2 = $result "
    Debuggable(result, message)
  }

  def g(a: Int): Debuggable = {
    val result = a * 3
    val message = s"g: a ($a) * 3 = $result "
    Debuggable(result, message)
  }

  def h(a: Int): Debuggable = {
    val result = a * 4
    val message = s"h: a ($a) * 4 = $result"
    Debuggable(result, message)
  }

  val finalResult = for {
    fResult <- f(100)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield hResult

  println(s"finalResult: $finalResult")
}