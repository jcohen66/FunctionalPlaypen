package errorhandling

object MakeIntOption extends App {

  def makeInt(s: String): Option[Int] = {
    try {
      Some(s.trim.toInt)
    } catch {
      case e: Exception => None
    }
  }

  val input = "2"

  makeInt(input) match {
    case Some(i) => println(s"i = $i")
    case None => println("toInt could not parse 'input'")
  }

  val result = makeInt(input).getOrElse(0)

  // Automatically wraps the error in a None.
  val result2 = for {
    x <- makeInt("1")
    y <- makeInt("2")
    z <- makeInt("hi")
  } yield x + y + z

  result2 match {
    case Some(i) => println(s"result2 = $result2")
    case None => println("could not add the three Strings as Int values")
  }
}
