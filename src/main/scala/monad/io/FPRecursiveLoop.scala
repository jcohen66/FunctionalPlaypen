package monad.io

import io_monad._

/**
  * This is the pattern for command line apps.
  * It recurses until terminal condition met
  * then returns an IO[Unit].
  */
object FPRecursiveLoop extends App {

  def loop: IO[Unit] = for {
    _       <- putStrLn("Type something: ")
    input   <- getLine
    _       <- putStrLn(s"You said '$input'.")
    _       <- if (input == "quit") IO(Unit) else loop // RECURSE
  } yield ()

  loop.run

}
