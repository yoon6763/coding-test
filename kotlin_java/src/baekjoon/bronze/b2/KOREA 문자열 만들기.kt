package baekjoon.bronze.b2

fun main() {
    val str = readln()
    var idx = 0
    for (c in str) if (c == "KOREA"[idx % 5]) idx++
    println(idx)
}