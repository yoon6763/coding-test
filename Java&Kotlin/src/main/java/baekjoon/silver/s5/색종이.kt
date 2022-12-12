package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val map = Array(101) { Array(101) { false } }

    repeat(n) {
        val (p1, p2) = readLine().split(" ").map { it.toInt() }

        repeat(10) { dx ->
            repeat(10) { dy ->
                map[p1 + dx][p2 + dy] = true
            }
        }
    }

    println(map.sumOf { it.count { it } })
}