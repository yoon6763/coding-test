package baekjoon.bronze.b2

fun main() {
    var max = 0
    var maxIndex = 0

    readln()
    repeat(9) {
        val teamMax = readln().split(" ").map { it.toInt() }.maxOrNull()!!
        if (teamMax > max) {
            max = teamMax
            maxIndex = it
        }
    }

    println(arrayOf("PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION", "SPG", "COMON", "ALMIGHTY")[maxIndex])
}