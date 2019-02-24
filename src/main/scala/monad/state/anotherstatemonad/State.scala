package monad.state.anotherstatemonad

case class State[A, S](blockOfCode: S => (A, S)) {

  // s1 = state1, s2 = state2, s3 = state3
  def flatMap[B](f: A => State[B, S]): State[B, S] = State { s1: S =>
    val (a, s2) = blockOfCode(s1)
    val stateChangeToB = f(a)
    val (b, s3) = stateChangeToB.blockOfCode(s2)
    (b, s3)
  }

  def map[B](f: A => B): State[B, S] = flatMap(a => State.lift(f(a)))

}

object State {

  /**
    * "Lifts" a value and a monad.state into a State[A, S]
    *
    * @param value
    * @tparam A
    * @tparam S
    * @return
    */
  def lift[A,S](value: A): State[A,S] = State(state => (value, state))
}

object Tester extends App {

  case class StringState(string: String)

  def concat(substr: String): State[StringState, String] = State { (s: String) =>
    val newString = s + substr
    (StringState(newString), newString)
  }

  val stateWithNewString: State[StringState, String] = for {
    _             <- concat("20")
    _             <- concat("15")
    totalString   <- concat("0")
  } yield totalString


  // THE ACTION BEGINS

  // 'run' is like 'unsafeRunSync' in the Cats '10' monad
  val result: (StringState, String) = stateWithNewString.blockOfCode("")

  println(s"StringState:   ${result._1}")
  println(s"Total String:  ${result._2}")
}