package baekjoon.bronze.b4

fun main() {
    val k = readln().toInt()
    for (i in 0..<k) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        println(n * m / 2)
    }
}