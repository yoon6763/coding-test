package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    readLine()
    val arr = readLine().split(" ").map { it.toInt() }
    println(arr.minOrNull()!! * arr.maxOrNull()!!)
}