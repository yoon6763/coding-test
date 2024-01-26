package baekjoon.bronze.b4

fun main() {
    val b = readln().toInt()
    val p = 5 * b - 400
    if (p == 100) println("$p\n0") else println("$p\n${if (p > 100) -1 else 1}")
}
