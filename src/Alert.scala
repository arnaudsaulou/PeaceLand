case class Alert(citizenID : Int)

object Alert{


  def createAlert(citizenID : Int): Alert
  = new Alert(citizenID)

 def getAlertCSV(alert: Alert): String = {
   alert.citizenID + ";\n"
 }
}