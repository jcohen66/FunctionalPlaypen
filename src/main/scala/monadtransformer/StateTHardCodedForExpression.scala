package monadtransformer

import monadtransformer.monads.{IO, Monad, StateT}

object StateTHardCodedForExpression extends App {

  implicit val IOMonad = new Monad[IO] {
    def lift[A](a: => A): IO[A] = {
      IO(a)
    }
    def flatMap[A, B](ma: IO[A])(f: A => IO[B]): IO[B] = ma.flatMap(f)
  }

  case class IntState(i: Int)

  /**
    * Defines the anonymous function that is being passed into
    * the run: => A parameter of the StateT
    *
    * @param i
    * @return
    */
  def add(i: Int) = StateT[IO, IntState, Int] { oldState =>
    val newValue = i + oldState.i
    val newState = oldState.copy(i = newValue)    // copy updates the field value in case class.
    // Wrap the result tuple in an IO.
    IO(newState, newValue)
  }

  def multiply(i: Int) = StateT[IO, IntState, Int] { oldState =>
    val newValue = i * oldState.i
    val newState = oldState.copy(i = newValue)
    IO(newState, newValue)
  }

  val a = add(1)                             //StateT[IO, IntState, Int]
  val b = a.run(IntState(1))                 //IO[(IntState, Int)]
  b.map(t => println(s"b state = ${t._1}"))  //prints “b state = IntState(2)”

  // a hard-coded example
  val forExpression: StateT[IO, IntState, Int] = for {
    _ <- add(2)        //3
    _ <- add(3)        //6
    x <- multiply(10)  //6x10
  } yield x

  // “run” the state
  val result: IO[(IntState, Int)] = forExpression.run(IntState(1))

  // print the final state
  result.map(tuple => println(s"IntState = ${tuple._1}"))

}
