package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val arr = List(n) { minOf(100, readln().replace("0", "9").replace("6", "9").toInt()) }
    println(Math.round(arr.sum().toDouble() / n))
}