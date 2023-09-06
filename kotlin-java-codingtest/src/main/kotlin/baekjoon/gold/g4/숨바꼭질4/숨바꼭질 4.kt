package baekjoon.gold.g4.숨바꼭질4

import java.util.*

data class Node(val pre: Int, val time: Int)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val maxPoint = 100000

    if (n == m) {
        println(0)
        println(n)
        return
    }

    val queue = LinkedList<Int>() as Queue<Int>
    queue.offer(n)

    // 직전 위치, 시간
    val visited = Array<Node?>(maxPoint + 1) { null }
    visited[n] = Node(-1, 0)

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        for (nx in arrayOf(cur - 1, cur + 1, cur * 2)) {
            if (nx !in 0..maxPoint) continue
            if (visited[nx] != null) continue

            visited[nx] = Node(cur, visited[cur]!!.time + 1)

            if (nx == m) {
                println(visited[cur]!!.time + 1)
                println(tracking(visited, nx))
            }

            queue.offer(nx)
        }
    }
}

fun tracking(visited: Array<Node?>, initialX: Int): String {
    val stack = Stack<Int>()
    stack.push(initialX)
    var cur = initialX

    while (visited[cur]!!.pre != -1) {
        stack.push(visited[cur]!!.pre)
        cur = visited[cur]!!.pre
    }

    return stack.reversed().joinToString(" ")
}
