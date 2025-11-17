package baekjoon.bronze.b3

fun main() {
    val (n, d) = readln().split(" ").map { it.toInt() }
    repeat(n) {
        println(readln().map {
            if (d == 2) {
                when (it) {
                    'd' -> 'b'
                    'b' -> 'd'
                    'q' -> 'p'
                    'p' -> 'q'
                    else -> it
                }
            } else {
                when (it) {
                    'd' -> 'q'
                    'b' -> 'p'
                    'q' -> 'd'
                    'p' -> 'b'
                    else -> it
                }
            }
        }.joinToString(""))
    }
}
