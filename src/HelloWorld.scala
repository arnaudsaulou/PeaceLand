import scala.util.Random

object HelloWorld {
  def main(args: Array[String]): Unit = {

    val droneMsg = DroneMsg(
      1,
      Location(14.0,15.5),
      List(
        Citizen(1,randomName(10), randomName(10)),
        Citizen(2,randomName(10), randomName(10))
      ),
      List("Hello","World")
    )

    println(droneMsg);
    //val x = List.fill(1000)(droneMsg);
  }

  def randomName(length: Int): String = length match{
    case 0 => "";
    case _ => randomName(length - 1) + randomChar();
  }

  def randomChar(): String = {
    val min = 65;
    val max = 90;
    (Random.nextInt(max-min) + min).toChar.toString;
  }
}
