package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    var sumGrade = 0.0
    var sumScore = 0.0

    repeat(20) {
        val line = readLine().split(" ")
        sumScore += if (line[2] != "P") line[1].toDouble() else 0.0
        sumGrade += line[1].toDouble() * when (line[2]) {
            "A+" -> 4.5
            "A0" -> 4.0
            "B+" -> 3.5
            "B0" -> 3.0
            "C+" -> 2.5
            "C0" -> 2.0
            "D+" -> 1.5
            "D0" -> 1.0
            else -> 0.0
        }
    }
    println(sumGrade / sumScore)
}