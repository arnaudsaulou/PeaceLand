case class CitizenReport (citizen : Citizen, location : Location, happinessLevel: Int);

object CitizenReport{

  def apply(citizen : Citizen, location : Location, happinessLevel: Int): CitizenReport
  = new CitizenReport(citizen, location, happinessLevel)

  def getCitizenReportCSV(citizenReport: CitizenReport): String = {
    Citizen.getCitizenCSV(citizenReport.citizen)+
      ";" + Location.getLocationCSV(citizenReport.location) +
      ";" + citizenReport.happinessLevel.toString
  }

}
