package baekjoon.bronze.b4

fun main() {
    val (w1, h1, w2, h2) = List(4) { readln().toInt() }
    print((h1 + h2 + maxOf(w1, w2)) * 2 + 4)
}