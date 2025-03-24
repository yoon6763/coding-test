package baekjoon.gold.g5.`맥주 마시면서 걸어가기`

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

data class Node(val x: Int, val y: Int) {
    constructor(pos: List<Int>) : this(pos[0], pos[1])
}

const val MAX_DISTANCE = 20 * 50
val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val home = Node(readLine().split(" ").map { it.toInt() })
        val gs25 = Array(n) { Node(readLine().split(" ").map { it.toInt() }) }
        val festival = Node(readLine().split(" ").map { it.toInt() })

        sb.appendLine(if (bfs(home, gs25, festival)) "happy" else "sad")
    }
    print(sb)
}

fun bfs(home: Node, gs25Nodes: Array<Node>, festival: Node): Boolean {
    val visited = BooleanArray(gs25Nodes.size)
    val q = LinkedList<Node>() as Queue<Node>
    q.offer(Node(home.x, home.y))

    while (q.isNotEmpty()) {
        val cur = q.poll()
        if (abs(cur.x - festival.x) + abs(cur.y - festival.y) <= MAX_DISTANCE) return true

        gs25Nodes.forEachIndexed { index, gs25 ->
            if (visited[index] || abs(cur.x - gs25.x) + abs(cur.y - gs25.y) > MAX_DISTANCE) return@forEachIndexed
            visited[index] = true
            q.offer(Node(gs25.x, gs25.y))
        }
    }

    return false
}