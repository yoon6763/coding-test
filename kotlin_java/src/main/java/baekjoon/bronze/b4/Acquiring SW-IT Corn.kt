package baekjoon.bronze.b4

fun main() {
    val (X, Y, Z) = readln().split(" ").map { it.toLong() }
    val (U, V, W) = readln().split(" ").map { it.toLong() }

    println(
        (U / 100) * X +
                (V / 50) * Y +
                (W / 20) * Z
    )
}
