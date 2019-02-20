package errorhandling

import scala.util.{Failure, Success, Try}

object MakeIntTry extends App {

  def makeInt(s: String): Try[Int] = Try(s.trim.toInt)


  makeInt("1")
  makeInt("foo")

  makeInt("hello") match {
    case Success(i) => println(s"Success, value is: $i")
    case Failure(s) => println(s"Failed, message is $s")
  }

  val answer = for {
    a <- makeInt("1")
    b <- makeInt("2")
  } yield a + b

  println(answer)
}
