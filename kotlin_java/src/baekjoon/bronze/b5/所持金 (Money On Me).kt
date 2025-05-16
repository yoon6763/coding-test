package baekjoon.bronze.b5

fun main() {
    val (a, b) = List(2) { readLine()!!.toInt() }
    println(a * 1000 + b * 10000)
}