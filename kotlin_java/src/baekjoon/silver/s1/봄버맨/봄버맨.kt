package baekjoon.silver.s1.`봄버맨`

import java.util.*

data class Node(val x: Int, val y: Int)

lateinit var map: Array<CharArray>
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nmt = readLine().split(" ").map { it.toInt() }
    n = nmt[0]
    m = nmt[1]
    val time = nmt[2] - 1

    map = Array(n) { readLine().toCharArray() }

    var switch = 0

    repeat(time) {
        when (switch) {
            0 -> dropBomb('o')
            1 -> explosionBomb('O')
            2 -> dropBomb('O')
            3 -> explosionBomb('o')
        }

        switch = (switch + 1) % 4
    }

    map.forEach { println(it.joinToString("") { it.uppercase() }) }
}

fun explosionBomb(bomb: Char) {
    val q = LinkedList<Node>() as Queue<Node>
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == bomb) {
                q.offer(Node(i, j))
            }
        }
    }

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()
        map[x][y] = '.'

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m) continue
            map[nx][ny] = '.'
        }
    }
}

fun dropBomb(bomb: Char) {
    for (i in 0..<n) {
        for (j in 0..<m) {
            if (map[i][j] == '.') {
                map[i][j] = bomb
            }
        }
    }
}