package monad

/**
  * A Functor is an object that can be mapped over.
  *
  * @tparam A
  */
trait Functor[A] {
  def map[B](f: A => B): Functor[B]
}
