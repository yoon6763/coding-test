package baekjoon.bronze.b4

fun main() {
    val (x, y, z) = Array(3) { readln().toDouble() }
    print(if (x + y <= z + 0.5) 1 else 0)
}