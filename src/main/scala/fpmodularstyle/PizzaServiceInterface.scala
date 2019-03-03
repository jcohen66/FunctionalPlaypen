package fpmodularstyle

trait PizzaServiceInterface {

  type Money = BigDecimal

  def addTopping(p: Pizza): Pizza
  def removeTopping(p: Pizza): Pizza
  def removeAllToppings(p: Pizza): Pizza

  def updateCrustSize(p: Pizza, cs: CrustSize): Pizza
  def updateCrustType(p: Pizza, ct: CrustType): Pizza

  def calculatePizzaPrice(
                         p: Pizza,
                         toppingsPrices: Map[Topping, Money],
                         crustSizePrices: Map[CrustSize, Money],
                         crustTypePrices: Map[CrustType, Money]
                         ): Money
}
