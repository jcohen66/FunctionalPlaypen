package monad.cats


import cats.effect.IO

/**
  * The IO Monad helps you compose functions in a for expression,
  * where those functions can be:
  *   a) pure functions
  *   b) functions with I/O side effects
  * ** EFFECT **
  *
  * After composing those function calls and saving the result
  * in a variable, you can trigger it later.
  * ** ACTION **
  *
  * The variable can be passed around.
  */
object Program extends App {

  // ** EFFECT **
  // Describe the effect by composing pure
  // and I/O side effect functions.
  val program: IO[Unit] = for {
    _      <- IO { println("Welcome to Scala!  What's your name?") }
    name   <- IO { scala.io.StdIn.readLine }
    nameUC = name.toUpperCase
    _      <- IO { println(s"Well hello, $nameUC!") }
  } yield ()

  // ...
  // ...
  // some time later ...
  // ...
  // ...
  // ** ACTION **
  // Trigger the described action sometime later in the application.
  program.unsafeRunSync()
}