package fpmodularstyle

case class Address (
  var street1: String,
  var street2: Option[String],
  var city: String,
  var state: String,
  var zipCode: String
)
