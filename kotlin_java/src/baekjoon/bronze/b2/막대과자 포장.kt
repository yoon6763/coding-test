package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(if ((n * m) % 3 == 0) "YES" else "NO")
}
