package model

import entity.PersonEntity

case class Person (firstName: String, lastName: String, address: Address) {
  def as[T](implicit f: Person => T) = f(this)
}

case class Address(city: String, state: String, pin: String)


object Person {

  /**
    * Mapper function that takes a PersonEntity and returns a Person case class
    *
    * @return
    */
  implicit def personEntityMapper = (person: Person) =>
    PersonEntity(
      person.firstName,
      person.lastName,
      person.address.city,
      person.address.state,
      person.address.pin
    )

}