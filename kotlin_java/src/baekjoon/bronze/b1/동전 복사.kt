package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val (x, y) = readln().split(" ").map { it.toInt() }
    println(if (n > 1) if ((x == 1 || x == n) && (y == 1 || y == n)) 2 else if ((x in 2 until n && (y == 1 || y == n)) || ((x == 1 || x == n) && y in 2 until n)) 3 else 4 else 0)
}
