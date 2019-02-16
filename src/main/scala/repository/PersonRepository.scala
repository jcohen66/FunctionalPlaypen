package repository

import entity.PersonEntity
import model.Person

import scala.collection.mutable

object PersonRepository {

  val personEntities: mutable.HashMap[String, PersonEntity] = mutable.HashMap();

  def getPerson(name: String): Person = {
    personEntities(name)
  }

  def apply() = {
    personEntities.clear()

    personEntities +=  "Tom" -> PersonEntity("Sawyer", "Tom", "Tulsa", "OK", "12345")
  }

}


