package monad.cats

import cats.effect.IO

object IOMonadAlmostHelloWorld extends App {

  // Describe how to print to the outside world but don't trigger it.
  val hello = IO { println("Hello, world")}

  // hello.unsafeRunSync() is never called so no action is ever triggered.
}
