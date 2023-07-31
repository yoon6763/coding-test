package baekjoon.bronze.b3

fun main() {
    var max = 0
    var current = 0
    repeat(10) {
        val (out, _in) = readln().split(" ").map { it.toInt() }
        current += _in - out
        max = maxOf(max, current)
    }
    println(max)
}