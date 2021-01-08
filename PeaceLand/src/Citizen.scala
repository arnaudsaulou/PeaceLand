case class Citizen(idCitizen: Int, nameCitizen: String, firstnameCitizen: String);

object Citizen{

  def getCitizenCSV(citizen: Citizen): String ={
    citizen.idCitizen +
      ";" + citizen.nameCitizen +
      ";" + citizen.firstnameCitizen
  }

}
