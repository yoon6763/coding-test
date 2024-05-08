package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    if (n % 2 == 1) {
        println("still running")
        return
    }
    var sum = 0
    repeat(n / 2) {
        val start = readln().toInt()
        val end = readln().toInt()
        sum += end - start
    }
    println(sum)
}