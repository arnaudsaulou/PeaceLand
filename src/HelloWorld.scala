import scala.util.Random

object HelloWorld {
  def main(args: Array[String]): Unit = {

    val droneMsg = DroneMsg(
      1,
      Location(14.0,15.5),
      List(
        Citizen(1,randomName(5).toString, randomName(5).toString),
        Citizen(2,randomName(5).toString, randomName(5).toString)
      ),
      List("Hello","World")
    )

    println(droneMsg);
    //val x = List.fill(1000)(droneMsg);
  }

  def randomName(length: Int): String = {
    var nom: String = null;
    if(length == 1) {
      return new Random().nextPrintableChar().toString();
    } else {
      var a = new Random().nextPrintableChar().toString() + randomName(length - 1);
      return (a);
    }
  }
}
