package functioninputparameters

case class Transform2ParamsTo1Param[A, B](fun: (A, A) => B)

object Transform2ParamsTo1Param extends App {

  def combineString(a: String, b: String) = a + b
  def combineInt(a: Int, b: Int) = a + b

  val x = Transform2ParamsTo1Param { combineString }
  val y = Transform2ParamsTo1Param { combineInt }
  val z = Transform2ParamsTo1Param { (a: Double, b: Double) => a + b }

  println(x.fun("Hello, ", "world"))
  println(y.fun(67, 3))
  println(z.fun(4.3, 5.7))
}
