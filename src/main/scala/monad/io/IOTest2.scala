package monad.io

import io_monad._

object IOTest2 extends App {

  def forExpression: IO[Unit] = for {
    _         <- putStrLn("First name?")
    firstName <- getLine
    _         <- putStrLn(s"Last name?")
    lastName  <- getLine
    fNameUC   = firstName.toUpperCase
    lNameUC   = lastName.toUpperCase
    _         <- putStrLn(s"First: $fNameUC, Last: $lNameUC")
  } yield ()  // returns IO[Unit]

  // run the block whenever you want to.
  // nothing happens until run is called.
  forExpression.run

}