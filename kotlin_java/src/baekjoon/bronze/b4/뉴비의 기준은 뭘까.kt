package baekjoon.bronze.b4

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(if (m <= 2) "NEWBIE!" else if (m <= n) "OLDBIE!" else "TLE!")
}