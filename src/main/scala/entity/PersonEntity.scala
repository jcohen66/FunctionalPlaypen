package entity

import model.{Address, Person, Student}

case class PersonEntity(firstName: String, lastName: String, city: String, state: String, pin: String) {

  def as[T](implicit f: PersonEntity => T) = f(this)
}

object PersonEntity {

  /**
    * Mapper function that takes a PersonEntity and returns a Person case class
    *
    * @return
    */
  implicit def personMapper = (personEntity: PersonEntity) =>
    Person(
      personEntity.firstName,
      personEntity.lastName,
      Address(
        personEntity.city,
        personEntity.state,
        personEntity.pin
      )
    )

  implicit def studentMapper = (personEntity: PersonEntity) =>
    Student(personEntity.firstName, personEntity.city)
}
