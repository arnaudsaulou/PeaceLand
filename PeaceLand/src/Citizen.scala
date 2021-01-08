case class Citizen(idCitizen: Int, nameCitizen: String, firstnameCitizen: String);

object Citizen{

  def apply(idCitizen: Int, nameCitizen: String, firstnameCitizen: String) : Citizen
  = new Citizen(idCitizen, nameCitizen, firstnameCitizen)

  def getCitizenCSV(citizen: Citizen): String ={
    citizen.idCitizen +
      ";" + citizen.nameCitizen +
      ";" + citizen.firstnameCitizen
  }

}
