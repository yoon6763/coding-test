package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    println(a / b + if (a % b > 0) 1 else 0)
}