package domain.alspizza.pos.model

import domain.alspizza.Money
import domain.{CrustSize, CrustType, Topping}

/**
  * the interface for the functions (services) that a DAO
  * for our app should implement
  */
trait PizzaDaoInterface {

  def getToppingPrices(): Map[Topping, Money]
  def getCrustSizePrices(): Map[CrustSize, Money]
  def getCrustTypePrices(): Map[CrustType, Money]

}