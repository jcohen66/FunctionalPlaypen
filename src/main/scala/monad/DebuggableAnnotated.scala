package monad

case class DebuggableAnnotated (value: Int, message: String) {

  def map(f: Int => Int): DebuggableAnnotated = {
    println("\n>>>> entered map")
    println(s"map: value: ${value}")
    println(s"map: msg: ${message}")
    val newValue = f(this.value)
    println(s"map: newValue: ${newValue}")
    println("<<<< leaving map <<<<\n")
    DebuggableAnnotated(newValue, this.message)
  }

  def flatMap(f: Int => DebuggableAnnotated): DebuggableAnnotated = {
    println("\n>>>> entered fmap")
    println(s"fmap: value: ${value}")
    println(s"fmap: msg: ${message}")
    val nextValue: DebuggableAnnotated = f(value)
    println(s"fmap: msg: ${message}")
    println(s"fmap: nextValue: ${nextValue}")
    println("<<<< leaving fmap <<<<\n")
    DebuggableAnnotated(nextValue.value, message + nextValue.message)
  }

}

object TesterAnnotated extends App {

  def f(a: Int): DebuggableAnnotated = {
    println(s"\n[f: a = ${a}]\n")
    val result = a * 2
    val message = s"f: a ($a) * 2 = $result "
    DebuggableAnnotated(result, message)
  }

  def g(a: Int): DebuggableAnnotated = {
    println(s"\n[g: a = ${a}]\n")
    val result = a * 3
    val message = s"g: a ($a) * 3 = $result "
    DebuggableAnnotated(result, message)
  }

  def h(a: Int): DebuggableAnnotated = {
    println(s"\n[h: a = ${a}]\n")
    val result = a * 4
    val message = s"h: a ($a) * 4 = $result"
    DebuggableAnnotated(result, message)
  }

  val finalResult = for {
    fResult <- f(100)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield hResult

  println("\n----- FINAL RESULT -----")
  println(s"final value: ${finalResult.value}")
  println(s"final msg:    \n${finalResult.message}")
}