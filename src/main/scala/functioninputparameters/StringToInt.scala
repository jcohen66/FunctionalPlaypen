package functioninputparameters

case class StringToInt(run: String => Int)

object StringToInt extends App {

  def len(s: String) = s.length

  val stringToInt = StringToInt { s: String => s.length }
  val namedStringToInt = StringToInt { len }

  println(stringToInt.run("bananas"))
  println(namedStringToInt.run("bananas"))
}
