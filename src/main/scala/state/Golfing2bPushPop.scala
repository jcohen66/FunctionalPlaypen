package state

/**
  * Managing state is often compared to pushing
  * and popping items to/from a list.
  */
object Golfing2bPushPop extends App {

  def push[A](xs: List[A], a: A): List[A] = a :: xs
  def pop[A](xs: List[A]): (A, List[A]) = Tuple2(xs.head, xs.tail)

  // model the three swings
  val s0 = Nil
  val s1 = push(s0, 20)
  val s2 = push(s1, 15)
  val s3 = push(s2, 0)

  val (swing3, state2) = pop(s3)

  print(swing3, state2)
}
