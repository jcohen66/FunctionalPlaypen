package monad.state

/**
  * State Monad is s wrapper around state.  Used to "lift" data
  * out of the wrapper.
  *
  * @param  run   FIP used to pass to anonymous function
  * @tparam S     generic type for state
  * @tparam A     generic type label
  */
case class State[S, A](run: S => (S, A)) {

  def flatMap[B](g: A => State[S, B]): State[S, B] = State { (s0: S) =>
    val (s1, a) = run(s0)
    g(a).run(s1)
  }

  def map[B](f: A => B): State[S, B] = flatMap(a => State.point(f(a)))

}


object State {

  /**
    * lifts (or wraps) a value and a state into ta State[S, A] monad.
    *
    * @param v    value
    * @tparam S   state
    * @tparam A   type
    * @return     State[S, A]
    */
  def point[S, A](v: A): State[S, A] = State(run = s => (s, v))
}


