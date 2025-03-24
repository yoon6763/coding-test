package baekjoon.bronze.b3

fun main() {
    val m = readln().toInt()
    println("%.1f".format(if (m <= 30) m / 2.0 else m * 3.0 / 2.0 - 30.0))
}