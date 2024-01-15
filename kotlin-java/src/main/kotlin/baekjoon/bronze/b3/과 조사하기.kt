package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val arr = Array(5) { 0 }
    repeat(readLine().toInt()) {
        val (g, c, n) = readLine().split(" ").map { it.toInt() }
        if (g == 1) arr[0]++
        else arr[c]++
    }
    println(arr[1] + arr[2])
    println(arr[3])
    println(arr[4])
    println(arr[0])
}