package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val totalMin = 24 * 60
    val curMin = (totalMin.toLong() * m / n).toInt()
    println(String.format("%02d:%02d", curMin / 60, curMin % 60))
}
