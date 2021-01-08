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
      ";" + droneReport.wordCaught.mkString(";")
  }

}

object WeekDays extends Enumeration {
  val Mon, Tue, Wed, Thu, Fri = Value
}