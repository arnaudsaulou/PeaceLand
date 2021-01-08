case class CitizenReport(droneReportId: Int, citizen: Citizen, happinessLevel: Int)

object CitizenReport {

  def getCitizenReportCSV(citizenReport: CitizenReport): String = {
    citizenReport.droneReportId + ";" +
      Citizen.getCitizenCSV(citizenReport.citizen) + ";" +
      citizenReport.happinessLevel.toString
  }

}
