package baekjoon.bronze.b4

fun main() {
    val (w, h) = readln().split(" ").map { it.toInt() }
    val (n, a, b) = readln().split(" ").map { it.toInt() }

    if (a > w || b > h) {
        println(-1)
        return
    }

    val ableWords = (w / a) * (h / b)
    println((n + ableWords - 1) / ableWords)
}