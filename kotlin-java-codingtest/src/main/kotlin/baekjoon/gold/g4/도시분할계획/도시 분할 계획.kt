package baekjoon.gold.g4.도시분할계획

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

lateinit var parent: Array<Int>

data class Node(var to: Int, var from: Int, var weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.weight - other.weight
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ").map { it.toInt() }

    val n = nm[0] // Node
    val m = nm[1] // Vertex

    val pq = PriorityQueue<Node>()
    parent = Array(n + 1) { it }

    repeat(m) {
        val abc = br.readLine().split(" ").map { it.toInt() }
        pq.add(Node(abc[0], abc[1], abc[2]))
    }

    var cnt = 0
    var total = 0
    val size = pq.size

    for (i in 0 until size) {
        val node = pq.poll()

        if (cnt == n - 2) break

        if (union(node.to, node.from)) {
            total += node.weight
            cnt++
        }
    }
    println(total)
}

fun find(x: Int): Int {
    return if (parent[x] == x) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val nx = find(x)
    val ny = find(y)
    return if (nx != ny) {
        parent[ny] = nx
        true
    } else false
}