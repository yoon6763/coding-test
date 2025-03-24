package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()

    repeat(n) {
        val line = readln().split(" ")
        val name = line[0]
        val score = line[1].toInt()

        val grade = when {
            score >= 97 -> "A+"
            score >= 90 -> "A"
            score >= 87 -> "B+"
            score >= 80 -> "B"
            score >= 77 -> "C+"
            score >= 70 -> "C"
            score >= 67 -> "D+"
            score >= 60 -> "D"
            else -> "F"
        }

        println("$name $grade")
    }
}
