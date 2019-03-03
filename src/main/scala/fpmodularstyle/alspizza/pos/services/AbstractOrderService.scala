package fpmodularstyle.alspizza.pos.services

import fpmodularstyle._
import fpmodularstyle.alspizza.Money

/**
  * Define as abstract because it must have a database
  * to be used.  It has to be REIFIED one more time
  * by extending it and implementing the methods.
  */
trait AbstractOrderService extends OrderServiceInterface {

  // create a concrete implementation of the trait so we
  // can use its `calculatePizzaPrice` function
  object PizzaService extends PizzaService
  import PizzaService.calculatePizzaPrice

  // all implementations of this trait will use these functions,
  // so go ahead and define them here
  private lazy val toppingPricesMap   = database.getToppingPrices()
  private lazy val crustSizePricesMap = database.getCrustSizePrices()
  private lazy val crustTypePricesMap = database.getCrustTypePrices()

  // the publicly-available service
  def calculateOrderPrice(o: Order): Money =
    calculateOrderPriceInternal(o, toppingPricesMap, crustSizePricesMap, crustTypePricesMap)

  private def calculateOrderPriceInternal(
                                           o: Order,
                                           toppingPrices: Map[Topping, Money],
                                           crustSizePrices: Map[CrustSize, Money],
                                           crustTypePrices: Map[CrustType, Money]
                                         ): Money = {
    val pizzaPrices: Seq[Money] = for {
      pizza <- o.pizzas
    } yield {
      calculatePizzaPrice(
        pizza,
        toppingPrices,
        crustSizePrices,
        crustTypePrices
      )
    }
    pizzaPrices.sum
  }

}

