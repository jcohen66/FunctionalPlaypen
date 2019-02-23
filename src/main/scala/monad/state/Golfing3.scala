package monad.state

object Golfing3 extends App {

  /**
    * Model the distance of each stroke.
    *
    * @param distance
    */
  case class GolfState(distance: Int)

  /**
    * Creates a new State instance thats created with an anonymous function.
    *
    * Anonymous function reads:
    *
    * Given an existing GolfState named s, calculate a new distance from s
    * to the new distance that was passed in.  Then use that new distance to
    * create a new GolfState, and then return that new GolfState and the new
    * distance as a Tuple2.
    *
    * @param distance
    * @return
    */
  def swing(distance: Int): State[GolfState, Int] = State { (s: GolfState) =>
    val newDistance = s.distance + distance
    (GolfState(newDistance), newDistance)
  }

  /**
    * Assigns a block of code which is a for expression that models
    * my three swings.  Does not need to carry over the previous monad.state.
    */
  val stateWithNewDistance: State[GolfState, Int] = for {
    _             <- swing(20)
    _             <- swing(15)
    totalDistance <- swing(0)
  } yield totalDistance

  // THE ACTION BEGINS

  val beginningState = GolfState(0)

  // 'run' is like 'unsafeRunSync' in the Cats '10' monad
  val result: (GolfState, Int) = stateWithNewDistance.run(beginningState)

  println(s"GolfState:       ${result._1}")
  println(s"Total Distance:  ${result._2}")
}
