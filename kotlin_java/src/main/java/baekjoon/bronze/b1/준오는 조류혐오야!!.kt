package baekjoon.bronze.b1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().split(" ") }
    println(arr.sumOf { it.sumOf { it.count { it == '9' } } } - maxOf(arr.maxOf { row -> row.sumOf { it.count { it == '9' } } }, (0..<m).maxOf { j -> arr.sumOf { it[j].count { it == '9' } } }))
}