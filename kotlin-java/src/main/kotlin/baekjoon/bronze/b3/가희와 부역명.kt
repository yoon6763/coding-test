package baekjoon.bronze.b3

fun main() {
    val line = readln()
    val (name, sub) = if (line.contains('(')) {
        val (stationName, subStationName) = line.split(" (", ")")
        stationName to subStationName
    } else {
        line to "-"
    }

    println(name)
    println(sub)
}