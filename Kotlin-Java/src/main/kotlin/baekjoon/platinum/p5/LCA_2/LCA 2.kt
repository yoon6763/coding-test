package baekjoon.platinum.p5.LCA_2

import java.lang.StringBuilder
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer
import kotlin.math.pow

lateinit var tree: Array<ArrayList<Int>>
lateinit var depth: Array<Int>
lateinit var parent: Array<Array<Int>>
lateinit var visited: Array<Boolean>
var kmax = 0

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    tree = Array(n + 1) { ArrayList() }

    repeat(n - 1) {
        val st = StringTokenizer(readLine())
        val (s, e) = Array(2) { st.nextToken().toInt() }
        tree[s].add(e)
        tree[e].add(s)
    }

    depth = Array(n + 1) { 0 }
    visited = Array(n + 1) { false }
    var temp = 1
    kmax = 0

    while (temp <= n) {
        temp = temp shl 1
        kmax++
    }

    parent = Array(kmax + 1) { Array(n + 1) { 0 } }
    treeBFS(1)

    for (k in 1..kmax) {
        for (n2 in 1..n) {
            parent[k][n2] = parent[k - 1][parent[k - 1][n2]]
        }
    }

    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        var (a, b) = Array(2) { st.nextToken().toInt() }

        if (depth[a] > depth[b]) {
            val temp = a
            a = b
            b = temp
        }
        for (k in kmax downTo 0) {
            if (2.toDouble().pow(k.toDouble()) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b]
                }
            }
        }

        for (k in kmax downTo 0) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a]
                b = parent[k][b]
            }
        }

        var LCA = a
        if (a != b) LCA = parent[0][LCA]
        sb.append(LCA).append("\n")
    }
    print(sb)
}


fun treeBFS(node: Int) {
    val q = LinkedList<Int>() as Queue<Int>
    q.offer(node)
    visited[node] = true
    var level = 1
    var nowSize = 1
    var cnt = 0

    while (q.isNotEmpty()) {
        val nowNode = q.poll()
        tree[nowNode].forEach { nextNode ->
            if (!visited[nextNode]) {
                visited[nextNode] = true
                q.add(nextNode)
                parent[0][nextNode] = nowNode
                depth[nextNode] = level
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