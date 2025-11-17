package baekjoon.bronze.b4

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(if (n >= 8) "satisfactory" else "unsatisfactory")
}
