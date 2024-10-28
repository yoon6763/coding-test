package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    print(List(m) { readln().split(" ").map { it.toInt() }.let { it[0] to it[1] } }
        .sortedByDescending { it.first }.filterIndexed { idx, (a, _) -> idx < m - 1 && a < n }
        .sumOf { (a, _) -> n - a })
}
