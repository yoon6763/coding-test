package baekjoon.bronze.b5

fun main() {
    val n = readln().toDouble()
    val result = n - 0.3
    println("%.10f".format(result).trimEnd('0').trimEnd('.'))
}