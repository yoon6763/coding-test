package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val rig = List(n) { readLine() }
        val (n2, m2) = readLine().split(" ").map { it.toInt() }
        val map = List(n2) { readLine() }

        println((0..n2 - n).sumOf { i ->
            (0..m2 - m).count { j ->
                rig == map.subList(i, i + n).map { it.substring(j, j + m) }
            }
        })
    }
}