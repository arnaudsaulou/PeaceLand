import java.io.{File, PrintWriter}

object Peaceland {
  def main(args: Array[String]): Unit = {

    val citizenReport = CitizenReport(
      Citizen(1, "name1", "firstname1"),
      Location(14.0, 15.5),
      14
    )

    val droneReport = DroneReport(
      1,
      List("Hello", "Word"),
      List.fill(1000)(citizenReport)
    )

    val writer = new PrintWriter(new File("List.csv"))
    writer.write(DroneReport.getDroneReportCSV(droneReport))

  }
}
