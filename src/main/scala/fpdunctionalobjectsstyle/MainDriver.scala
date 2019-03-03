package fpdunctionalobjectsstyle

object MainDriver extends App {

  // initialize the data from database
  val toppingPrices = MockPizzaDao.getToppingPrices()
  val crustSizePrices = MockPizzaDao.getCrustSizePrices()
  val crustTypePrices = MockPizzaDao.getCrustTypePrices()

  // create a pizza
  val pizza1 = Pizza(
    MediumCrustSize,
    ThinCrustType,
    Seq(Cheese, Pepperoni)
  )

  // make sure you can create modified versions of
  // the initial pizza.
  val pizza2 = pizza1.addTopping(Sausage)
  val pizza3 = pizza2.updateCrustSize(LargeCrustSize)
  println(s"pizza3: $pizza3")

  val pizzaPrice = pizza3.getPrice(
    toppingPrices,
    crustSizePrices,
    crustTypePrices
  )
  println(s"price of pizza3: $pizzaPrice")

  // can also do this
  val pizza4 = pizza1.addTopping(Onions)
    .updateCrustSize(LargeCrustSize)
    .updateCrustType(ThickCrustType)
  println(s"pizza4: pizza4")

}
