package either

object EitherConverter extends App {
  // The converter extends List and Map capabilities
  object EitherConverter {
    implicit class EitherList[E, A](le: List[Either[E, A]]){
      def toEitherList: Either[E, List[A]] = {
        def helper(list: List[Either[E, A]], acc: List[A]):
        Either[E, List[A]] = list match {
          case Nil => Right(acc)
          case x::xs => x match {
            case Left(e) => Left(e)
            case Right(v) => helper(xs, acc :+ v)
          }
        }

        helper(le, Nil)
      }
    }

    implicit class EitherMap[K, V, E](me: Map[K, Either[E, V]]) {
      def toEitherMap: Either[E, Map[K, V]] = me.map{
        case (k, Right(v)) => Right(k, v)
        case (_, e) => e
      }.toList.toEitherList
        .map(l => l.asInstanceOf[List[(K, V)]].toMap)
    }
  }

  // The usual import
  import EitherConverter._

  // A good list and a bad list
  val listOfEitherOk: List[Either[Error, String]] =
    List(Right("Scala"), Right("is"), Right("cool!"))
  val listOfEitherError: List[Either[Error, String]] =
    List(Right("Scala"), Left(new Error("Noooooo!!")), Right("cool!"))
  // A good map and a bad map
  val mapEitherOk: Map[String, Either[Error, Int]] =
    Map("key1" -> Right(1), "key2" -> Right(2))
  val mapEitherError: Map[String, Either[Error, Int]] =
    Map("key1" -> Right(1), "key2" -> Left(new Error("Ops!")))

  // Done. B)
  println(listOfEitherError.toEitherList)
  println(listOfEitherOk.toEitherList)
  println(mapEitherOk.toEitherMap)
  println(mapEitherError.toEitherMap)

}
