package baekjoon.bronze.b2

fun main() {
    repeat(readln().toInt()) {
        val (a, b) = readln().split(' ').map { it.toLong() }
        val n = a + b
        println(n * n * (n - 1) / 2)
    }
}
