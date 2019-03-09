package either

object TailRecursiveEither extends App {
  // A good list and a bad list
  val listOfEitherOk: List[Either[Error, String]] =
    List(Right("Scala"), Right("is"), Right("cool!"))
  val listOfEitherError: List[Either[Error, String]] =
    List(Right("Scala"), Left(new Error("Nooo!!")), Right("cool!"))

  // Tail recursive function for the conversion
  def eitherOfList(le: List[Either[Error, String]]):
  Either[Error, List[String]] = {
    def helper(list: List[Either[Error, String]], strs: List[String]):
    Either[Error, List[String]] = list match {
      case Nil => Right(strs)
      case x :: xs => x match {
        case Left(e) => Left(e)
        case Right(v) => helper(xs, strs :+ v)
      }
    }

    helper(le, Nil)
  }

  // That's it!
  println(eitherOfList(listOfEitherOk))
  println(eitherOfList(listOfEitherError))

}
