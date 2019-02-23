package monad.io


/**
  * Defines the impure functions that interact with
  * the outside world.  These can be used inside a
  * for comprehension because IO has map and flatMap.
  */
package object io_monad {

  def getLine: IO[String] = IO(scala.io.StdIn.readLine())
  def putStrLn(s: String): IO[Unit] = IO(println(s))

}
