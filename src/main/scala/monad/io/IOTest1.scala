package monad.io

import io_monad._



object IOTest1 extends App {

  for {
    _         <- putStrLn("First Name?")
    firstName <- getLine
    _         <- putStrLn(s"Last name?")
    lastName  <- getLine
    _         <- putStrLn(s"First: $firstName, Last: $lastName")
  } yield ()

}
