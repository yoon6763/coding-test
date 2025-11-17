package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()
    for (i in 1..n) sb.append(i)
    println(sb.indexOf(n.toString()) + 1)
}