package fpmodularstyle.alspizza.pos.services

import fpmodularstyle.Order
import fpmodularstyle.alspizza.Money
import fpmodularstyle.alspizza.pos.model.PizzaDaoInterface

/**
  * Use references to avoid hardwiring resources.
  */
trait OrderServiceInterface {

  // implementing classes should provide their own database
  // that is an instance of PizzaDaoInterface, such as
  // MockPizzaDao, TestPizzaDao, or ProductionPizzaDao
  protected def database: PizzaDaoInterface

  def calculateOrderPrice(o: Order): Money

}
