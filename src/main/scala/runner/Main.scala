package runner

import entity.PersonEntity
import repository.PersonRepository


object Main extends Greeting with App {
  val p = PersonRepository.getPerson("Tom")
  println("Found Person: " + p )
  val pe: PersonEntity = p;
  println("Convert Person: " + pe )
}

trait Greeting {
  lazy val greeting: String = "hello"
}
