package baekjoon.bronze.b3

fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    print(if (a == 3L) (1L + (2L..<2L + b).sum()) else (1L + (a - 1) + (1..<b).sumOf { (a - 1 + it * (a - 2)) }))
}
