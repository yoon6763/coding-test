package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    readLine()
    print(readLine().split(" ").map { it.toInt() }.sorted().joinToString(" "))
}