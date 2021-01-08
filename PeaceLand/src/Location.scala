case class Location(latitude: Double, longitude: Double);

object Location {

  def getLocationCSV(location: Location): String = {
    location.latitude + ";" + location.longitude
  }

}
