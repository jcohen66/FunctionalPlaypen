package iocontrol

import iocontrol.Control._

import scala.util.{Failure, Success, Try}

object FileIO extends App {

  def readTextFileAsTry(filename: String): Try[List[String]] = {
    Try {
      val lines = using(io.Source.fromFile(filename)) { source =>
        (for (line <- source.getLines) yield line).toList
      }
      lines
    }
  }

  val passwdFile = readTextFileAsTry("/etc/passwd-foo")
  passwdFile match {
    case Success(lines) => lines.foreach(println)
    case Failure(s) => println(s"Failed, message is: $s")
  }
}
