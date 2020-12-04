import scala.util.Random

object HelloWorld {
  def main(args: Array[String]): Unit = {

    val droneMsg = DroneMsg(
      1,
      Location(14.0,15.5),
      List(
        Citizen(1,randomName(), randomName()),
        Citizen(2,randomName(), randomName())
      ),
      List("Hello","World")
    )

    println(droneMsg);
    //val x = List.fill(1000)(droneMsg);
  }

  def randomName(): String = {
    Random.alphanumeric.dropWhile(_.isDigit).toString();
  }
}
