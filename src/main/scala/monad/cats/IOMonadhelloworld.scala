package monad.cats

import cats.effect.IO

/**
  * Implments the Cats Effect from the Cats Functional Library.
  *
  */
object IOMonadhelloworld extends App {

  // Describe how to print to the outside world but don't trigger it.
  val hello: IO[Unit] = IO { println("Hello, world") }

  // Actually trigger the described function.
  hello.unsafeRunSync()

}
