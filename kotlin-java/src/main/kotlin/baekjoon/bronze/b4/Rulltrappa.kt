package baekjoon.bronze.b4

fun main() {
    val (M, S, G) = readln().split(" ").map { it.toFloat() }
    val (A, B) = readln().split(" ").map { it.toFloat() }
    val (L, R) = readln().split(" ").map { it.toFloat() }

    val lv = if (M % G == 0f) M / G else M / G + 1
    val rv = if (M % S == 0f) M / S else M / S + 1

    if (lv + L / A < rv + R / B) println("friskus") else println("latmask")
}
