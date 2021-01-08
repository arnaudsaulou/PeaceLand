case class DroneReport(
                        idDrone: Int,
                        wordCaught: List[String],
                        location : Location,
                        citizenReports: List[CitizenReport],
                        day : WeekDays.Value,
                        micIsWorking : Boolean
                      )

object DroneReport{

  def apply(idDrone: Int, wordCaught: List[String], location : Location, citizenReports: List[CitizenReport], day : WeekDays.Value, micIsWorking : Boolean): DroneReport
  = new DroneReport(idDrone, wordCaught, location, citizenReports, day, micIsWorking)

  def getDroneReportCSV(droneReport: DroneReport): String = {
    droneReport.idDrone +
      ";" + droneReport.wordCaught.mkString(";") + ";" + Location.getLocationCSV(droneReport.location) +
      ";\n" + droneReport.citizenReports.map(
      citizenReport => CitizenReport.getCitizenReportCSV(citizenReport)).mkString("\n")
  }
}