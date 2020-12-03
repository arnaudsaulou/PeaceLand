object HelloWorld {
  def main(args: Array[String]): Unit = {

    val droneMsg = DroneMsg(
      1,
      Location(14.0,15.5),
      List(
        Citizen(1,"name1","firstname1"),
        Citizen(2,"name2","firstname2")
      ),
      List("Hello","World")
    )

    println(droneMsg)
  }
}
