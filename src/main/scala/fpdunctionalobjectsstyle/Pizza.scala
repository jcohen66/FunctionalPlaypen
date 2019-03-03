package fpdunctionalobjectsstyle

// Topping Enumeration
sealed trait Topping
case object Cheese extends Topping
case object Pepperoni extends Topping
case object Sausage extends Topping
case object Mushrooms extends Topping
case object Onions extends Topping

// CrustSize Enumeration
sealed trait CrustSize
case object SmallCrustSize extends CrustSize
case object MediumCrustSize extends CrustSize
case object LargeCrustSize extends CrustSize

// CrustType Enumeration
sealed trait CrustType
case object RegularCrustType extends CrustType
case object ThinCrustType extends CrustType
case object ThickCrustType extends CrustType


// the data model
case class Pizza(
                crustSize: CrustSize,
                crustType: CrustType,
                val toppings: Seq[Topping]
                ) {

  def addTopping(t: Topping): Pizza = {
    this.copy(toppings = this.toppings :+ t)
  }

  def removeTopping(t: Topping): Pizza = {
    val newToppings = utils.ListUtils.dropFirstMatch(this.toppings, t)
    this.copy(toppings = newToppings)
  }

  def removeAllToppings(p: Pizza): Pizza = {
    val newToppings = Seq[Topping]()
    this.copy(toppings = newToppings)
  }

  def updateCrustSize(cs: CrustSize): Pizza = {
    this.copy(crustSize = cs)
  }

  def updateCrustType(ct: CrustType): Pizza = {
    this.copy(crustType = ct)
  }

  def getPrice(
              toppingPrices: Map[Topping, Money],
              crustSizePrices: Map[CrustSize, Money],
              crustTypePrices: Map[CrustType, Money]
              ) : Money = {
    val base = BigDecimal(10)
    val numToppings = this.toppings.size
    val price = base + 1.00 * numToppings
    price
  }
}

