package monad

class Wrapper[A](value: A) {
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

  val x = new Wrapper(1)
  x.map(_ * 2)

  for {
    i <- x
  } yield i * 2

  val result: Wrapper[Int] = for {
    a <- new Wrapper(1)
    b <- new Wrapper(2)
    c <- new Wrapper(3)
  } yield a + b + c

  println(result)

  val result2: Wrapper[String] = for {
    a <- new Wrapper("hello, ")
    b <- new Wrapper("world")
  } yield a + b

  println(result2)
}
