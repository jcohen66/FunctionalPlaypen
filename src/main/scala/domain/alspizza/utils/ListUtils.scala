package domain.alspizza.utils

/**
  * Alvinj Utility function.
  */
object ListUtils {

  def dropFirstMatch[A](ls: Seq[A], value: A): Seq[A] = {
    val index = ls.indexOf(value)  //index is -1 if there is no match
    // not found
    if (index < 0) {
      ls
    } else if (index == 0) {
      // its the head so return the tail
      ls.tail
    } else {
      // splitAt keeps the matching element in the second group
      val (a, b) = ls.splitAt(index)
      a ++ b.tail
    }
  }

}
