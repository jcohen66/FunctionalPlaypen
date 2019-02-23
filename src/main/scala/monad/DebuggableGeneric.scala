package monad

case class DebuggableGeneric[A] (value: A, message: String) {

  def map[B](f: A => B): DebuggableGeneric[B] = {
    val newValue = f(this.value)
    DebuggableGeneric(newValue, this.message)
  }

  def flatMap[B](f: A => DebuggableGeneric[B]): DebuggableGeneric[B] = {
    val nextValue: DebuggableGeneric[B] = f(value)
    DebuggableGeneric(nextValue.value, message + nextValue.message)
  }

}

object Tester extends App {

  def f(a: Int): DebuggableGeneric[Int] = {
    val result = a * 2
    val message = s"f: a ($a) * 2 = $result "
    DebuggableGeneric(result, message)
  }

  def g(a: Int): DebuggableGeneric[Int] = {
    val result = a * 3
    val message = s"g: a ($a) * 3 = $result "
    DebuggableGeneric(result, message)
  }

  def h(a: Int): DebuggableGeneric[Int] = {
    val result = a * 4
    val message = s"h: a ($a) * 4 = $result"
    DebuggableGeneric(result, message)
  }

  val finalResult = for {
    fResult <- f(100)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield hResult

  println(s"finalResult: $finalResult")
}