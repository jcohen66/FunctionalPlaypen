package fpmodularstyle

import java.awt.Color

trait Animal

abstract class AnimalWithTail(tailColor: Color) extends Animal

trait DogTailServices {

  // This trait can only be mixed into classes that extend AnimalWithTrait
  this: AnimalWithTail =>

  def wagTail = println("wag tail")
  def lowerTail = println("lower tail")
  def raiseTail = println("raise tail")
  def curlTail = println("curl tail")
}

trait DogMouthServices {
  // This trait can only be mixed into classes that extend AnimalWithTrait
  this: AnimalWithTail =>

  def bark = println("bark")
  def lick = println("licking")
}
