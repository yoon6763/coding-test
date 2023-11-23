package baekjoon.silver.s5

fun main() {
    val line = readLine()!!.replace("XXXX", "AAAA").replace("XX", "BB")
    println(if (line.indexOf('X') == -1) line else -1)
}