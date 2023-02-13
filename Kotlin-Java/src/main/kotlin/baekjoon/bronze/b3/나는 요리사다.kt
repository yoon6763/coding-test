package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val arr = Array(5) { readLine().split(" ").map { it.toInt() }.toTypedArray().sum() }
    val max = arr.maxOrNull()!!
    println("${arr.indexOf(max) + 1} $max")
}