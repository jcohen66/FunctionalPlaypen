package monad.state.anotherstatemonad

case class State[A, S](run: S => (A, S)) {

  // s1 = state1, s2 = state2, s3 = state3
  def flatMap[B](f: A => State[B, S]): State[B, S] = State { s1: S =>
    val (a, s2) = run(s1)
    val stateChangeToB = f(a)
    val (b, s3) = stateChangeToB.run(s2)
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