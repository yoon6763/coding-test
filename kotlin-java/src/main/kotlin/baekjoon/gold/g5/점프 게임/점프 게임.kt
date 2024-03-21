package baekjoon.gold.g5.`점프 게임`

import java.util.*

data class Node(val line: Int, val distance: Int)

const val LEFT = 0
const val RIGHT = 1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val map = Array(2) { readLine() }
    val visited = Array(2) { BooleanArray(n) }

    val q = LinkedList<Node>() as Queue<Node>
    q.offer(Node(LEFT, 0))

    var phase = 0

    while (q.isNotEmpty()) {
        repeat(q.size) {
            val cur = q.poll()
            val reversed = if (cur.line == LEFT) RIGHT else LEFT

            for (next in arrayOf(
                Node(cur.line, cur.distance + 1),
                Node(cur.line, cur.distance - 1),
                Node(reversed, cur.distance + k)
            )) {
                if (next.distance >= n) {
                    println(1)
                    return
                }

                if (next.distance <= phase || visited[next.line][next.distance] || map[next.line][next.distance] == '0') continue
                visited[next.line][next.distance] = true
                q.offer(Node(next.line, next.distance))
            }
        }
        phase++
    }

    println(0)
}