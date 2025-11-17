package baekjoon.bronze.b3

fun main() {
    var total = 0

    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        total += a - b
        println(total)
    }
}
