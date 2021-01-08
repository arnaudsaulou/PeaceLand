case class Citizen(idCitizen: Int, nameCitizen: String, firstnameCitizen: String);

object Citizen{

  def getCitizenCSV(citizen: Citizen): String ={
    citizen.idCitizen +
      ";" + citizen.nameCitizen +
      ";" + citizen.firstnameCitizen
  }

  def parseFromCSV(citizenCSV: String):Citizen = {
    val citizenSplit = citizenCSV.split(";")
    Citizen(
      Integer.parseInt(citizenSplit(0)),
      citizenSplit(1),
      citizenSplit(2)
    )
  }

}
