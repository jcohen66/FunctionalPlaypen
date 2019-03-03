package monadtransformer.monads

object IOMonad {
  implicit val IOMonad = new Monad[IO] {
    override def flatMap[A, B](ma: IO[A])(f: A => IO[B]): IO[B] = ma.flatMap(f)

    override def lift[A](a: => A): IO[A] = IO(a)
  }
}
