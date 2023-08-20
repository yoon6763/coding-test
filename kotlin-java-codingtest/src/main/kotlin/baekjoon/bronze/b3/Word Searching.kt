package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val word = readLine()
    var cnt = 0
    while (true) cnt += (readLine() ?: break).split(" ").count { word in it }
    println(cnt)
}