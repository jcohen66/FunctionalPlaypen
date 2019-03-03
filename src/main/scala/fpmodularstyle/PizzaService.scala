package fpmodularstyle

import utils.ListUtils

trait PizzaService extends PizzaServiceInterface {

  def addTopping(p: Pizza, t: Topping): Pizza = {
    val newToppings = p.toppings :+ t
    p.copy(toppings = newToppings)
  }

  def removeTopping(p: Pizza, t: Topping): Pizza = {
    val newToppings = ListUtils.dropFirstMatch(p.toppings, t)
    p.copy(toppings = newToppings)
  }
}
