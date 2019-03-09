package either

object MapEither extends App {

  // A stupid computation that may result in a Left or a Right
  def uncertainComputation(x: Float): Either[Error, String] =
    if (x > 0.5) Right("That's right!") else Left(new Error(":-("))

  // We define a List of values and map our computation on it
  val listOfValues =
    List(0.1f, 0.8f, 0.6f, 0.5f, 0.3f)
  val listOfResults =
    listOfValues.map(uncertainComputation)

  // We do the same with a Map, mapping the computation
  // on the values of the map
  val mapOfValues = Map(
    "key1" -> 0.1f,
    "key2" -> 0.8f,
    "key3" -> 0.6f,
    "key4" -> 0.5f,
    "key5" -> 0.3f,
  )
  val mapOfResults =
    mapOfValues.mapValues(uncertainComputation)

  // Yikes!
  println(listOfResults)
  println(mapOfResults)

}
