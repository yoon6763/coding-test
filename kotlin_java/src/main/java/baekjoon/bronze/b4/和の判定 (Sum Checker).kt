package baekjoon.bronze.b4

fun main() {
    val (a, b, c) = Array(3) { readln().toInt() }.sorted()
    print(if (a + b == c) 1 else 0)
}