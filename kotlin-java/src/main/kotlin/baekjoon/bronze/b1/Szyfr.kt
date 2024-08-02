package baekjoon.bronze.b1

fun main() {
    val m = readln().split(" ")[1][0]
    val s = readln()
    val diff = s.groupingBy { it }.eachCount().maxByOrNull { it.value }!!.key - m
    println(s.map { ((it - diff - 'A' + 26) % 26).toChar() + 'A'.code }.joinToString(""))
}