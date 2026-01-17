package baekjoon.bronze.b4

fun main() {
    val W = readln().toLong()
    val N = readln().toLong()
    val totalFeet = W * 5280
    val result = totalFeet / N
    println(result)
}