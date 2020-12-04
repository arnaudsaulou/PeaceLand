object HelloWorld {
  def main(args: Array[String]): Unit = {

    val citizenReport = CitizenReport(
      Citizen(1,"name1","firstname1"),
      Location(14.0,15.5),
      14
    )

    val droneReport = DroneReport(
      1,
      List("Hello","Word"),
      List(citizenReport,citizenReport)
    )

    println(DroneReport.getDroneReportCSV(droneReport))
  }
}
