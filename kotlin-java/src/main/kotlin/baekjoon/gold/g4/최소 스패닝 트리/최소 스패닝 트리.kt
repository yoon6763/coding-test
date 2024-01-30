package baekjoon.gold.g4.`최소 스패닝 트리`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Node(val from: Int, val to: Int, val weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.weight - other.weight
    }
}

var total = 0
lateinit var parent: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val ve = br.readLine().split(" ")
    val v = ve[0].toInt()
    val e = ve[1].toInt()

    parent = Array(v + 1) { it }

    val pq = PriorityQueue<Node>()

    repeat(e) {
        val line = br.readLine().split(" ").map { it.toInt() }
        pq.add(Node(line[0], line[1], line[2]))
    }

    val size = pq.size
    for (i in 0 until size) {
        val node = pq.poll()
        val to = find(node.to)
        val from = find(node.from)

        if (!isSameParent(to, from)) {
            total += node.weight
            union(node.to, node.from)
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

fun union(x: Int, y: Int) {
    val nx = find(x)
    val ny = find(y)
    if (nx != ny) {
        parent[ny] = nx
    }
}

fun isSameParent(x: Int, y: Int): Boolean {
    val nx = find(x)
    val ny = find(y)
    return nx == ny
}
