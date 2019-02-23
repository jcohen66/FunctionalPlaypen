package state

case class GolfState(distance: Int)

/**
  * Manually manage state.
  *
  */
object Golfing1 extends App {

  def nextStroke(previousState: GolfState, distanceOfNextHit: Int): GolfState = {
      GolfState(previousState.distance + distanceOfNextHit)
    }

  val state1 = GolfState(20)
  val state2 = nextStroke(state1, 15)

  val state3 = nextStroke(state2, 10)

  println(state1)
  println(state2)
  println(state3)

}
