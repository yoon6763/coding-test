package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val s = readln()
    var cnt = 0
    for (i in 0..<n / 2) if (s[i] != s[n - 1 - i]) cnt++
    println(cnt)
}