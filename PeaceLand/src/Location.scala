case class Location(latitude: Double, longitude: Double);

object Location {

  def getLocationCSV(location: Location): String = {
    location.latitude + ";" + location.longitude
  }

  def parseFromCSV(locationCSV: String): Location = {
    val locationSplit = locationCSV.split(";")
    Location(locationSplit(0).toDouble, locationSplit(1).toDouble)
  }


}
