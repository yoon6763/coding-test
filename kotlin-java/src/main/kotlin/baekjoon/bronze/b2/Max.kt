package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val count = Array(10001) { 0 }
    repeat(readLine().toInt()) { count[readLine().toInt()]++ }
    println(count.maxOrNull())
}