package fpmodularstyle.alspizza.pos.services

import fpmodularstyle.alspizza.pos.model.MockPizzaDao

object MockDbOrderService extends AbstractOrderService {

  val database = MockPizzaDao

}
