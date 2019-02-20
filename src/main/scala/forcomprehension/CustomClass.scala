package forcomprehension

abstract class CustomClass[A] {
  def map[B](f: A => B): CustomClass[B]
  def flatMap[B](f: A => CustomClass[B]): CustomClass[B]
  def withFilter(p: A => Boolean): CustomClass[A]
  def foreach(b: A => Unit): Unit
}
