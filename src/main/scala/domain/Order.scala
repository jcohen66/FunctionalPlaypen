package domain



case class Order(
                pizzas: Seq[Pizza],
                customer: Customer
                )
