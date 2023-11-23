package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val time = readln().split(" ").map { it.toInt() }
    val y = time.sumOf { (it / 30 + 1) * 10 }
    val m = time.sumOf { (it / 60 + 1) * 15 }
    when {
        y < m -> println("Y $y")
        y > m -> println("M $m")
        else -> println("Y M $y")
    }
}