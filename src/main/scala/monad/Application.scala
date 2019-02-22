package monad

object Application extends App {

  val x = Wrapper(1)
  x.map(_ * 2)

  for {
    i <- x
  } yield i * 2

  val result: Wrapper[Int] = for {
    a <- Wrapper(1)
    b <- Wrapper(2)
    c <- Wrapper(3)
  } yield a + b + c

  println(result)

  val result2: Wrapper[String] = for {
    a <- Wrapper("hello, ")
    b <- Wrapper("world")
  } yield a + b

  println(result2)
}
