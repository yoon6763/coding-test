package baekjoon.bronze.b4

fun main() {
    repeat(readln().toInt()) {
        var cnt = 0
        val (a1, b1, c1) = readln().split(" ").map { it.toInt() }
        for (x in 1..a1) {
            for (y in 1..b1) {
                for (z in 1..c1) {
                    if (x % y == y % z && y % z == z % x) cnt++
                }
            }
        }
        println(cnt)
    }
}