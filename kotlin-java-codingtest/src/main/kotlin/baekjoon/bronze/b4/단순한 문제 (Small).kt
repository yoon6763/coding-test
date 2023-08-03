package baekjoon.bronze.b4

fun main() {
    var cnt = 0
    repeat(readln().toInt()) {
        val (a1, b1, c1) = readln().split(" ").map { it.toInt() }
        val (a2, b2, c2) = readln().split(" ").map { it.toInt() }
        for (x in a1..a2) for (y in b1..b2) for (z in c1..c2) if (x % y == y % z && y % z == z % x) cnt++
    }
    println(cnt)
}