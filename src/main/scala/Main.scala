import entity.PersonEntity
import repository.PersonRepository

object Main extends App {
  val p = PersonRepository.getPerson("Tom")
  println("Found Person: " + p )
  val pe: PersonEntity = p;
  println("Convert Person: " + pe )
}
