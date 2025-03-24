package baekjoon.bronze.b4

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()
    readln().split(" ").map { it.toInt() }.forEach { i ->
        result.add(
            when ((i * 100) / n) {
                in 0..4 -> 1
                in 5..11 -> 2
                in 12..23 -> 3
                in 24..40 -> 4
                in 41..60 -> 5
                in 61..77 -> 6
                in 78..89 -> 7
                in 90..96 -> 8
                in 97..100 -> 9
                else -> 0
            }
        )
    }
    println(result.joinToString(" "))
}