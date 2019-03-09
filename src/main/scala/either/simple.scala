package either

object simple extends App {
  // When we define an Either,
  // it can be (either) a Right or a Left
  val ok: Either[Error, String] =
  Right("That's right!")
  val error: Either[Error, String] =
    Left(new Error("That's an error!"))

  // A stupid computation that may result in a Left or a Right
  def uncertainComputation(x: Float): Either[Error, String] =
    if (x > 0.5)
      Right("That's right!")
    else
      Left(new Error("That's an error!"))

  println(ok)
  println(uncertainComputation(0.6f))
  println(error)
  println(uncertainComputation(0.3f))
}
