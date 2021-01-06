case class DroneReport(
                        idDrone: Int,
                        wordCaught: List[String],
                        location : Location,
                        citizenReports: List[CitizenReport]

                      )

object DroneReport{

  def apply(idDrone: Int, wordCaught: List[String], location : Location, citizenReports: List[CitizenReport]): DroneReport
  = new DroneReport(idDrone, wordCaught, location, citizenReports)

  def getDroneReportCSV(droneReport: DroneReport): String = {
    droneReport.idDrone +
      ";" + droneReport.wordCaught.mkString(";") + ";" + Location.getLocationCSV(droneReport.location) +
      ";\n" + droneReport.citizenReports.map(
      citizenReport => CitizenReport.getCitizenReportCSV(citizenReport)).mkString("\n")
  }

}