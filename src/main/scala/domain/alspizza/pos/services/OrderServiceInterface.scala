package domain.alspizza.pos.services

import domain.Order
import domain.alspizza.Money
import domain.alspizza.pos.model.PizzaDaoInterface

trait OrderServiceInterface {

  // implementing classes should provide their own database
  // that is an instance of PizzaDaoInterface, such as
  // MockPizzaDao, TestPizzaDao, or ProductionPizzaDao
  protected def database: PizzaDaoInterface

  def calculateOrderPrice(o: Order): Money

}
