package monadtransformer

import monadtransformer.monads.Monad

object OptionMonad {

  implicit val OptionMonad = new Monad[Option] {

    override def flatMap[A, B](ma: Option[A])(f: A => Option[B]): Option[B] = ma.flatMap(f)
    override def lift[A](a: => A): Option[A] = Some(a)
  }

}
