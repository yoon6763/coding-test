package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().toCharArray() }
    val resultMap = Array(n) { Array(m) { '.' } }

    repeat(n) { x -> repeat(m) { y -> if (map[x][y] == '#') for (i in x..x + 1) for (j in y..y + 1) resultMap[i][j] = '#' } }
    resultMap.forEach { println(it.joinToString("")) }
}