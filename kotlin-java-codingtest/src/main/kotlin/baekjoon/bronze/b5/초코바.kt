package baekjoon.bronze.b5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    println(if(n * 100 >= m) "Yes" else "No")
}