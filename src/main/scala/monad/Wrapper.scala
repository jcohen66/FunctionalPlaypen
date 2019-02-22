package monad

/**
  * Note the private constructor and companion object.
  *
  * @param value
  * @tparam A
  */
class Wrapper[A] private (value: A) {
  def map[B](f: A => B): Wrapper[B] = {
    // apply 'f' to an 'Int' to get a new 'Int'
    val newInt = f(value)

    // wrap the new 'Int' in a Wrapper
    new Wrapper(newInt)
  }

  def flatMap[B](f: A => Wrapper[B]): Wrapper[B] = {
    // apply 'f' to an 'Int' to get a Wrapper[Int]
    // return a new Wrapper[Int]
    f(value)
  }

  override def toString = value.toString
}

object Wrapper extends App {

  def apply[A](value: A): Wrapper[A] = new Wrapper(value)

}



