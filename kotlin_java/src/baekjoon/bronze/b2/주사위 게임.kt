package baekjoon.bronze.b2

fun main() {
    val (a1, b1, a2, b2) = readln().split(" ").map { it.toInt() }
    val (a3, b3, a4, b4) = readln().split(" ").map { it.toInt() }

    val a = a1 + a2 + b1 + b2
    val b = a3 + a4 + b3 + b4

    println(
        when {
            a == b -> "Tie"
            a > b -> "Gunnar"
            else -> "Emma"
        }
    )
}
