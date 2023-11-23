package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val days = Array(32) { 0 }
    repeat(n) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        for (i in start until end) {
            days[i]++
        }
    }
    val bookCnt = readln().toInt()
    if(bookCnt < days.maxOrNull()!!) {
        println(0)
    } else {
        println(1)
    }
}