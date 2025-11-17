package baekjoon.gold.g3.LCA

import java.lang.StringBuilder
import java.util.LinkedList
import java.util.Queue

lateinit var visited: Array<Boolean>
lateinit var parent: Array<Int>
lateinit var depth: Array<Int>
lateinit var tree: Array<ArrayList<Int>>

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    tree = Array(n + 1) { ArrayList() }

    for (i in 0 until n - 1) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        tree[start].add(end)
        tree[end].add(start)
    }

    depth = Array(n + 1) { 0 }
    parent = Array(n + 1) { 0 }
    visited = Array(n + 1) { false }

    treeBFS(1)

    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        var (node1, node2) = readLine().split(" ").map { it.toInt() }
        if (depth[node1] < depth[node2]) {
            val temp = node1
            node1 = node2
            node2 = temp
        }

        // 두 노드의 레벨 맞추기
        while (depth[node1] != depth[node2]) {
            node1 = parent[node1]
        }

        // 두 노드가 같을 떄 까지 (같은 부모가 나올 때 까지) 한 칸씩 올림
        while (node1 != node2) {
            node1 = parent[node1]
            node2 = parent[node2]
        }
        sb.append(node1).append("\n")
    }
    print(sb)
}

fun treeBFS(node: Int) {
    val q = LinkedList<Int>() as Queue<Int>
    q.add(node)
    visited[node] = true
    var level = 1
    var nowSize = 1
    var cnt = 0

    while (q.isNotEmpty()) {
        val target = q.poll()
        tree[target].forEach { next ->
            if (!visited[next]) {
                visited[next] = true
                q.add(next)
                parent[next] = target
                depth[next] = level
            }
        }
        cnt++
        if (cnt == nowSize) {
            cnt = 0
            nowSize = q.size
            level++
        }
    }
}