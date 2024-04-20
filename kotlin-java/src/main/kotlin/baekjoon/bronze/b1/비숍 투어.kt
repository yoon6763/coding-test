package baekjoon.bronze.b1


fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val (sx, sy) = readln().split(" ").map { it.toInt() }
    val (ex, ey) = readln().split(" ").map { it.toInt() }
    if (sx == ex && sy == ey) println("YES")
    else if (n == 1 || m == 1) println("NO")
    else if ((sx + sy + ex + ey) % 2 == 0) println("YES")
    else println("NO")
}