case class DroneReport(
                        idReport: Int,
                        idDrone: Int,
                        wordCaught: List[String],
                        location: Location,
                        citizenReports: List[CitizenReport],
                        day: WeekDays.Value,
                        micIsWorking: Boolean
                      )

object DroneReport {

  def getDroneReportCSV(droneReport: DroneReport): String = {
    droneReport.idReport +
      ";" + droneReport.idDrone +
      ";" + Location.getLocationCSV(droneReport.location) +
      ";" + droneReport.day +
      ";" + droneReport.micIsWorking +
      ";" + droneReport.wordCaught.mkString(";")
  }

  def parseFromCSV(droneReportCSV: String): DroneReport = {
    val droneReportSplit = droneReportCSV.split(";")
    DroneReport(
      Integer.parseInt(droneReportSplit(0)),
      Integer.parseInt(droneReportSplit(1)),
      droneReportSplit.takeWhile(s => s != null).toList,
      Location.parseFromCSV(droneReportSplit(2)),
      null,
      WeekDays.withName(droneReportSplit(3)),
      droneReportSplit(4).toBoolean
    )
  }

}

object WeekDays extends Enumeration {
  val Mon, Tue, Wed, Thu, Fri = Value
}