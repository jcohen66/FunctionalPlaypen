package errorhandling

object MakeIntEither extends App {

  def makeInt(s: String): Either[String, Int] = {
    try {
      Right(s.trim.toInt)
    } catch {
      case e: Exception => Left(e.toString)
    }
  }


  makeInt("1")

  makeInt("11f") match {
    case Left(s) => println("Error message: " + s)
    case Right(i) => println("Desired answer " + i)
  }
}
