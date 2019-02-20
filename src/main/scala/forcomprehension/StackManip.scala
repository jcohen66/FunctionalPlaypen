package forcomprehension

import scala.collection.immutable.Stack

case class Person(firstName: String, lastName: String)

object StackManip extends App {

  val people = List(
    Person("barney", "rubble"),
    Person("betty", "rubble"),
    Person("fred", "flintstone")
  )

  val namesStartWithB = for {

    p <- people                   // generator
    fname = p.firstName           // definition
    if( fname.startsWith("b"))    // filter

  } yield fname.toUpperCase

  namesStartWithB.foreach(println)

}
