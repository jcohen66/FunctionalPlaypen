package monad

case class Bag[A](content: A) {
  def map[B](f: A => B): Bag[B] = Bag(f(content))
  def flatMap[B](f: A => Bag[B]): Bag[B] = f(content)
  def flatten = content
}


object app extends App {

  case class Sugar(weight: Double)

  // the guy who is expert at making sugar half
  def half = (sugar: Sugar) => Sugar(sugar.weight)

  // map is the guy in our story who can perform operations
  // by unwrapping the bag and then calling respective function
  // and wraps the content back in a bag.
  val sugarBag: Bag[Sugar] = Bag(Sugar(1))  // Bag functor of type Sugar

  val halfSugarBag: Bag[Sugar] = sugarBag.map(sugar => half(sugar))

  val sugarBagIdentity = Bag(Sugar(1))


  println(sugarBag.map(identity))

  val x: Option[Int] = Some(1)
  val y: Int = 2
  val m: Int = 2

  val z = if(x.isDefined) Some((x.get + y) * m) else None
  println(z)

  val a: Option[Int] = Some(1)
  val b: Int = 2
  val c: Int = 2

  val d = a.map(e => (e + b) * c)

  val f = a
    .map(_ + b)
    .map(_ + c)

  println(f)

  def double = (sugar: Sugar) => Bag(Sugar(sugar.weight))

  def doubleSugarBag = sugarBag.map(sugar => double(sugar)).flatten

  def doubleSugarBagF = sugarBag.flatMap(sugar => double(sugar))

  println(double)
  println(doubleSugarBag)
  println(doubleSugarBagF)



}