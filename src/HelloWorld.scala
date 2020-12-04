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

    println(droneMsg);
    //val x = List.fill(1000)(droneMsg);
  }

  def randomName(): String = {
    Random.alphanumeric.dropWhile(_.isDigit).toString();
    println(DroneReport.getDroneReportCSV(droneReport))
  }
}
