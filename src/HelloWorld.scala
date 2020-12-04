import java.io.{File, PrintWriter}

object HelloWorld {
  def main(args: Array[String]): Unit = {

    val droneMsg = DroneMsg(
      1,
      Location(14.0,15.5),
      List(
        Citizen(1,"name1","firstname1")
      ),
      List("Hello","World")
    )
    val x = List.fill(1000)(droneMsg)
    val writer = new PrintWriter(new File("List.csv"))
    x.foreach(x => writer.write(x.toString + "\n"))
  }
}
