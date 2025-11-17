package baekjoon.bronze.b5

fun main() {
    val ab = readLine()!!.split(" ").map { it.toLong() }
    println((ab[0] + ab[1]) * (ab[0] - ab[1]))
}