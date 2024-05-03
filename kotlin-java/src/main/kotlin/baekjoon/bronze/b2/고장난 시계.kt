package baekjoon.bronze.b2

fun main() {
    val (x, y) = readln().split(" ").map { it.toInt() }
    val z = x % 30

    if (z * 12 == y) {
        println("O")
    } else {
        println("X")
    }
}
