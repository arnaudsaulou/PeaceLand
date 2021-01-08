case class Location(latitude: Double, longitude: Double);

object Location {

  def apply(latitude: Double, longitude: Double): Location
  = new Location(latitude, longitude)

  def getLocationCSV(location: Location): String = {
    location.latitude + ";" + location.longitude
  }

}
