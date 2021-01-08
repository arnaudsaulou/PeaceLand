import java.io.{File, PrintWriter}
import scala.util.Random

object Peaceland {

  def main(args: Array[String]): Unit = {

    val droneReport = DroneReport(
      1,
      List("Peace", "Watcher"),
      Location(Random.between(-90.0, 90.0), Random.between(-180.0, 180.0)),
      List.tabulate(1000)(citizenID => GenerateCitizenReport(citizenID))
    )

    val unhappyCitizen = droneReport.citizenReports.filter(citizenReport => citizenReport.happinessLevel < 3)
    val writerAlert = new PrintWriter(new File("Alert.csv"))
    unhappyCitizen.foreach(citizenReport => writerAlert.write(Alert.getAlertCSV(new Alert(citizenReport.citizen.idCitizen))))
    writerAlert.close()

    val writer = new PrintWriter(new File("ReportDrone.csv"))
    writer.write(DroneReport.getDroneReportCSV(droneReport))

  }

  private def GenerateCitizenReport(citizenID : Int) =  {


    CitizenReport(
      Citizen(citizenID+1, randomString(10), randomString(10)),
      Random.between(1,10),
    )
  }

  private def randomString(length: Int): String = length match{
    case 0 => "";
    case _ => randomString(length - 1) + randomChar();
  }

  private def randomChar(): String = {
    val min = 65
    val max = 90
    (Random.nextInt(max-min) + min).toChar.toString
  }


}
