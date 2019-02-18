package json

import net.liftweb.json._
import net.liftweb.json.JsonDSL._

object LiftJsonListsVersion2 extends App {
  val merc = Person_("Mercedes", Address_("Somewhere", "KY"))
  val mel = Person_("Mel", Address_("Lake Zurich", "IL"))
  val friends = List(merc, mel)
  val p = Person_("Alvin Alexander", Address_("Talkeetna", "AK"))
  p.friends = friends
  val json =
    ("person" ->
      ("name" -> p.name) ~
        getAddress(p.address) ~
        getFriends(p)
      )
  println(prettyRender(json))
  def getFriends(p: Person_) = {
    ("friends" ->
      p.friends.map { f =>
        ("name" -> f.name) ~
          getAddress(f.address)
      })
  }
  def getAddress(a: Address_) = {
    ("address" ->
      ("city" -> a.city) ~
        ("state" -> a.state))
  }
}

case class Person_(name: String, address: Address_) {
  var friends = List[Person_]()
}

case class Address_(city: String, state: String)
