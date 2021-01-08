case class DroneReport(
                        idReport: Int,
                        idDrone: Int,
                        wordCaught: List[String],
                        location: Location,
                        citizenReports: List[CitizenReport],
                        day: WeekDays.Value,
                        micIsWorking: Boolean
                      )

object DroneReport {

  def getDroneReportCSV(droneReport: DroneReport): String = {
    droneReport.idReport +
      ";" + droneReport.idDrone +
      ";" + Location.getLocationCSV(droneReport.location) +
      ";" + droneReport.day +
      ";" + droneReport.micIsWorking +
      ";" + droneReport.wordCaught.mkString(";")
  }

  def parseFromCSV(droneReportCSV: Iterator[String]): Iterator[DroneReport] = {

    droneReportCSV.map(
      droneReportLine => {
        val droneReportSplit = droneReportLine.split(";")
        DroneReport(
          Integer.parseInt(droneReportSplit(0)),
          Integer.parseInt(droneReportSplit(1)),
          droneReportSplit.takeWhile(s => s != null).toList,
          Location.parseFromCSV(droneReportSplit(2)),
          null,
          WeekDays.withName(droneReportSplit(3)),
          droneReportSplit(4).toBoolean
        )
      }
    )

  }

}