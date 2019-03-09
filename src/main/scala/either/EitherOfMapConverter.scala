package either

object EitherOfMapConverter extends App {
  // A good map and a bad map
  val mapEitherOk: Map[String, Either[Error, Int]] =
    Map("key1" -> Right(1), "key2" -> Right(2))
  val mapEitherError: Map[String, Either[Error, Int]] =
    Map("key1" -> Right(1), "key2" -> Left(new Error("Ops!")))

  // We can generalize our list converter!
  def eitherOfList[E, A](le: List[Either[E, A]]):
  Either[E, List[A]] = {
    def helper(list: List[Either[E, A]], strs: List[A]):
    Either[E, List[A]] = list match {
      case Nil => Right(strs)
      case x::xs => x match {
        case Left(e) => Left(e)
        case Right(v) => helper(xs, strs :+ v)
      }
    }

    helper(le, Nil)
  }

  // Function to do the trick.
  // It exploits the converter we defined on List
  def eitherOfMap(m: Map[String, Either[Error, Int]]):
  Either[Error, Map[String, Int]] =
    eitherOfList(m.map{
      case (k, Right(v)) => Right(k, v)
      case (_, e) => e
    }.toList).map(l => l.asInstanceOf[List[(String, Int)]].toMap)

  //Ta-dah!
  println(eitherOfMap(mapEitherOk))
  println(eitherOfMap(mapEitherError))
}
