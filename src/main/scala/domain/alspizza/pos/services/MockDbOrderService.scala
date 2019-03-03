package domain.alspizza.pos.services

import domain.alspizza.pos.model.MockPizzaDao

object MockDbOrderService extends AbstractOrderService {

  val database = MockPizzaDao

}
