package baekjoon.bronze.b4

fun main() {
    val (w, l, h) = List(3) { readln().toInt() }
    val bigger = maxOf(w, l)
    val smaller = minOf(w, l)
    if (smaller >= 2 * h && bigger <= 2 * smaller) println("good") else println("bad")
}