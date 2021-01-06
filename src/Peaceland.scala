import java.io.{File, PrintWriter}
import scala.util.Random

object Peaceland {
  def main(args: Array[String]): Unit = {

    val citizenReport = CitizenReport(
      Citizen(1, randomString(10), randomString(10)),
      Random.between(1, 10),
    )

    val droneReport = DroneReport(
      1,
      List("Peace", "Watcher"),
      Location(Random.between(-90.0, 90.0), Random.between(-180.0, 180.0)),
      List.fill(1000)(citizenReport)
    )

    val writer = new PrintWriter(new File("List.csv"))
    writer.write(DroneReport.getDroneReportCSV(droneReport))

  }

  def randomString(length: Int): String = length match{
    case 0 => "";
    case _ => randomString(length - 1) + randomChar();
  }

  def randomChar(): String = {
    val min = 65
    val max = 90
    (Random.nextInt(max-min) + min).toChar.toString
  }
}
