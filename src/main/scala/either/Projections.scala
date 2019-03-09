package either

object Projections extends App {
  // We define a Right and a Left to
  // try the projection
  val theRight: Either[Error, String] =
  Right("hello!")
  val theLeft: Either[Error, String] =
    Left(new Error("I'm an error!"))

  println(theRight.right.get) // OK
  //println(theRight.left.get) // Exception!
  //println(theLeft.right.get) // Exception!
  println(theLeft.left.get) // OK


  // Lets create a list of Either to operate on
  val list: List[Either[Int, String]] =
    List(Right("i"), Left(0), Right("am"),
      Left(10), Right("luca"), Left(100), Right("florio"))

  // The right projection map the function toUpperCase only if the
  // Either is a Right, leaving it unchanged otherwise. The left
  // projection multiply the Int only if the Either is a Left,
  // leaving it unchanged otherwise. In this way, we can put
  // the mapping on the list one after the other. Cool! :-)
  val newList = list.map(_.right.map(_.toUpperCase))
    .map(_.left.map(_ * 100))

  println(newList)
}
