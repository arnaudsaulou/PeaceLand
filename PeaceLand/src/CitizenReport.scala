case class CitizenReport(droneReportId: Int, citizen: Citizen, happinessLevel: Int)

object CitizenReport {

  def getCitizenReportCSV(citizenReport: CitizenReport): String = {
    citizenReport.droneReportId + ";" +
      Citizen.getCitizenCSV(citizenReport.citizen) + ";" +
      citizenReport.happinessLevel.toString
  }

  def parseFromCSV(citizenReportCSV: String): CitizenReport={
    val lineSplit = citizenReportCSV.split(";")
    CitizenReport(
      Integer.parseInt(lineSplit(0)),
      Citizen.parseFromCSV(lineSplit(1)),
      Integer.parseInt(lineSplit(2)))
  }

}
