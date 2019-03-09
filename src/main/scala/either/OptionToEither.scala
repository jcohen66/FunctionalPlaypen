package either

object OptionToEither extends App {
  // From an Option to an Either saying:
  // if the option is defined,
  // make it a Right with the Option value,
  // otherwise put this Error in the Left.
  val ok: Either[Error, String] =
  Some("Yeah!").toRight(new Error("Boooo!"))
  val error: Either[Error, String] =
    None.toRight(new Error("Boooo!"))

  println(ok)
  println(error)

  // Same as before, but reversed:
  // if the option is defined,
  // make it a Left with the Option value,
  // otherwise put this string in the Right.
  val okLeft: Either[Error, String] =
  Some(new Error("Boooo!")).toLeft("Yeah!")
  val errorLeft: Either[Error, String] =
    None.toLeft("Yeah!")

  println(okLeft)
  println(errorLeft)


}
