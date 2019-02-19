package currying

object Wrap extends App {

  def wrap(prefix: String)(html: String)(suffix: String) = {
    prefix + html + suffix
  }

  val wrapWithDiv = wrap("<div>")(_: String)("</div>")
  val wrapWithPre = wrap("<pre>")(_: String)("</pre>")



  val hello = "Hello, world"
  val result = wrap("<div>")(hello)("</div>")

  val r2 = wrapWithDiv("<p>Hello, world</p>")
  println(r2)
}
