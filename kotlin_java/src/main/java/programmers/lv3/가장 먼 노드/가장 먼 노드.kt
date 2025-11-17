package programmers.lv3.`가장 먼 노드`

import java.util.*
import kotlin.math.*

fun solution(n: Int, edge: Array<IntArray>): Int {
    val visited = Array(n + 1) { -1 }
    val connected = Array(n + 1) { ArrayList<Int>() }

    for(e in edge) {
        connected[e[0]].add(e[1])
        connected[e[1]].add(e[0])
    }

    val q = LinkedList<Int>() as Queue<Int>
    visited[1] = 0
    q.offer(1)

    var maxDistance = 0

    while(q.isNotEmpty()) {
        val target = q.poll()
        maxDistance = max(maxDistance, visited[target])

        for(node in connected[target]) {
            if(visited[node] == -1) {
                q.offer(node)
                visited[node] = visited[target] + 1
            }
        }
    }

    return visited.count { it == maxDistance }
}