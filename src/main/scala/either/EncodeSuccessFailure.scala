package either

object EncodeSuccessFailure extends App {

  type Error = String
  type Success = String

  def eval(price: Double): Either[Error, Success] = {
    val result = price match {
      case (p) if p > 2.00 => Right(s"Sold at profit: ${p}")
      case (l) => Left(s"Sold at loss: ${l}")
    }
    result
  }

  def display(price: Double) {
    eval(price) match {
      case Right(p) => println(p)
      case Left(p) => println(p)
    }
  }

  def codify(price: Double): Double = {
    eval(price) match {
      case Right(p) => price
      case Left(p) => 0.0
    }
  }

  val priceList = List(1.00, 2.00, 3.00, 0.99, 4.00, 0.50, 13.00)

  priceList.map{display}

  val revenue = priceList.foldLeft(0.00) { (a, c) => a + codify(c) }
  println(revenue)


}
