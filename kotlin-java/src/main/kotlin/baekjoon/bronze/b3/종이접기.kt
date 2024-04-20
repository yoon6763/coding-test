package baekjoon.bronze.b3

fun main() {
    var s = 0L
    val n = readln().toInt()
    repeat(n) {
        s += readln().split(" ").sumOf { it.toLong() }
    }
    println(s)
}
