package errorhandling

import org.scalactic.{Bad, ErrorMessage, Good, Or}

/**
  * Demonstrates Scalactic Or type.
  */
object makeIntOr extends App {

  def makeInt(s: String): Int Or ErrorMessage = {
    try {
      Good(s.trim.toInt)
    } catch {
      case e: Exception => Bad(e.toString)
    }
  }


  println(makeInt("1"))

  println(makeInt("boo"))

  makeInt("11f") match {
    case Good(i) => println("Answer: " + i)
    case Bad(msg) => println("Error: " + msg)
  }

  val result = for {
    a <- makeInt("1")
    b <- makeInt("foo")
  } yield a + b

  println(result)
}
