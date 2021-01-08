case class CitizenReport (citizen : Citizen, happinessLevel: Int)

object CitizenReport{

  def apply(citizen : Citizen, happinessLevel: Int): CitizenReport
  = new CitizenReport(citizen, happinessLevel)

  def getCitizenReportCSV(citizenReport: CitizenReport): String = {
    Citizen.getCitizenCSV(citizenReport.citizen) +
      ";" + citizenReport.happinessLevel.toString
  }

}
