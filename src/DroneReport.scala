case class DroneReport(
                        idDrone: Int,
                        wordCaught: List[String],
                        citizenReports: List[CitizenReport]
                      )

object DroneReport{

  def apply(idDrone: Int, wordCaught: List[String], citizenReports: List[CitizenReport]): DroneReport
  = new DroneReport(idDrone, wordCaught, citizenReports)

  def getDroneReportCSV(droneReport: DroneReport): String = {
    droneReport.idDrone +
      ";" + droneReport.wordCaught.mkString(";") +
      ";\n" + droneReport.citizenReports.map(
      citizenReport => CitizenReport.getCitizenReportCSV(citizenReport)).mkString("\n")
  }

}