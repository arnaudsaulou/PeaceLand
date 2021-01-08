import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

import java.io.{File, PrintWriter}
import scala.util.Random

object Peaceland {

  val pathToDroneReports = "../data/DroneReports.csv"
  val pathToCitizenReports = "../data/CitizenReports.csv"
  val pathToAlerts = "../data/Alerts.csv"

  def main(args: Array[String]): Unit = {
    generateFakeData()
    stat1()
  }

  private def generateFakeData(): Unit = {
    val droneReports = List.tabulate(1000)(droneReportId => generateDroneReport(droneReportId))

    val writerDroneReports = new PrintWriter(new File(pathToDroneReports))
    droneReports.foreach(droneReport => writerDroneReports.write(DroneReport.getDroneReportCSV(droneReport) + "\n"))
    writerDroneReports.close()

    val writerCitizenReports = new PrintWriter(new File(pathToCitizenReports))
    droneReports.foreach(droneReport =>
      droneReport.citizenReports.foreach(
        citizenReport => writerCitizenReports.write(CitizenReport.getCitizenReportCSV(citizenReport) + "\n"))
    )
    writerCitizenReports.close()

    val writerAlert = new PrintWriter(new File(pathToAlerts))
    droneReports.foreach(droneReport => lookForUnhappyCitizen(droneReport, writerAlert))
    writerAlert.close()

  }

  private def lookForUnhappyCitizen(droneReport: DroneReport, writerAlert: PrintWriter): Unit = {
    val unhappyCitizen = droneReport.citizenReports.filter(citizenReport => citizenReport.happinessLevel < 3)
    unhappyCitizen.foreach(
      citizenReport => writerAlert.write(
        citizenReport.droneReportId +
          ";" + Alert.getAlertCSV(new Alert(citizenReport.citizen.idCitizen))
      )
    )
    writerAlert.write("\n")
  }

  private def generateDroneReport(droneReportId: Int): DroneReport = {
    DroneReport(
      droneReportId,
      randomBetweenInt(1, 10), //Id drone
      generateWordsList(),
      Location(randomBetweenDouble(-90.0, 90.0), randomBetweenDouble(-180.0, 180.0)),
      List.tabulate(1000)(citizenID => generateCitizenReport(droneReportId, citizenID)),
      WeekDays.Fri,
      micIsWorking = randomMicDown()
    )
  }

  private def generateCitizenReport(reportID: Int, citizenID: Int): CitizenReport = {
    CitizenReport(
      reportID,
      Citizen((citizenID + 1), randomString(10), randomString(10)),
      randomBetweenInt(1, 10)
    )
  }

  private def generateWordsList(): List[String] = {
    val nbWords = randomBetweenInt(10, 1000)
    List.fill(nbWords)(randomString(randomBetweenInt(3, 10)))
  }

  private def randomString(length: Int): String = length match {
    case 0 => "";
    case _ => randomString(length - 1) + randomChar();
  }

  private def randomChar(): String = {
    val min = 65
    val max = 90
    (Random.nextInt(max - min) + min).toChar.toString
  }

  private def randomMicDown(): Boolean = {
    val micDownProba = randomBetweenInt(0, 100)
    if (micDownProba < 15) {
      true
    } else {
      false
    }
  }

  private def randomBetweenInt(start: Int, end: Int): Int = {
    start + Random.nextInt((end - start) + 1)
  }

  private def randomBetweenDouble(start: Double, end: Double): Double = {
    start + (end - start) * Random.nextDouble()
  }

  private def loadCitizenReport(): RDD[CitizenReport] = {
    val conf = new SparkConf().setAppName("PeaceLand").setMaster("local[*]")
    val sc = SparkContext.getOrCreate(conf)
    sc.textFile(pathToCitizenReports).mapPartitions(CitizenReport.parseFromCSV)
  }

  private def loadDroneReport(): RDD[DroneReport] = {
    val conf = new SparkConf().setAppName("PeaceLand").setMaster("local[*]")
    val sc = SparkContext.getOrCreate(conf)
    sc.textFile(pathToDroneReports).mapPartitions(DroneReport.parseFromCSV)
  }

  private def stat1(): Unit = {
    loadDroneReport().map((_,1)).reduceByKey(_+_)
  }
}
