package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var count = 0

    repeat(n) {
        val word = readln()
        if (word.filter { it in 'A'..(('A' + m - 1).toChar()) }.toSet().size == word.length) count++
    }

    print(count)
}