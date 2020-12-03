
case class Citizen(
                    idCitizen: Int,
                    nameCitizen: String,
                    firstnameCitizen: String
                  )

case class Location(
                     latitude: Double,
                     longitude: Double
                   )

case class DroneMsg(
                     idDrone: Int,
                     locationDrone: Location,
                     nearbyCitizen: List[Citizen],
                     wordCaught: List[String]
                   )