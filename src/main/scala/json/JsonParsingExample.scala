package json

import net.liftweb.json._

// a case class to represent a mail server
case class MailServer(url: String, username: String, password: String)

object JsonParsingExample extends App {
  implicit val formats = DefaultFormats
  // simulate a json string
  val jsonString = """
  {
  "url": "imap.yahoo.com",
  "username": "myusername",
  "password": "mypassword"
  }
  """

  // convert a String to a JValue object
  val jValue = parse(jsonString)

  // create a MailServer object from the string
  val mailServer = jValue.extract[MailServer]
  println(mailServer.url)
  println(mailServer.username)
  println(mailServer.password)
}
