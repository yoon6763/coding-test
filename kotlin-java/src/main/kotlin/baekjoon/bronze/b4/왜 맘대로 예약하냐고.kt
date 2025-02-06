package baekjoon.bronze.b4


fun main() {
    val (t, x) = readln().split(" ").map { it.toInt() }
    val n = readln().toInt()
    println(if ((0..<n).count { readln(); x in readln().split(" ").map { it.toInt() } } == n) "YES" else "NO")
}