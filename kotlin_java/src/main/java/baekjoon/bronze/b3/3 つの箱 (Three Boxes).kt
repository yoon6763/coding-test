package baekjoon.bronze.b3

fun main() {
    readln()
    var pos = 1
    var count = 0

    readln().forEach {
        pos = when (it) {
            'L' -> (pos - 1).coerceAtLeast(1)
            'R' -> (pos + 1).coerceAtMost(3)
            else -> pos
        }.also { if (it == 3) count++ }
    }

    println(count)
}
