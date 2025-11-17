package baekjoon.gold.g3.정복자

import java.util.PriorityQueue
import java.util.StringTokenizer

lateinit var parent: Array<Int>

data class Node(val from: Int, val to: Int, val weight: Long) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return (this.weight - other.weight).toInt()
    }
}

fun main() {

    val br = System.`in`.bufferedReader()

    val (n, m, t) = br.readLine().split(" ").map { it.toInt() }
    parent = Array(n + 1) { it }


    val pq = PriorityQueue<Node>()

    repeat(m) {
        val st = StringTokenizer(br.readLine())
        pq.offer(Node(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toLong()))
    }

    var cnt = 0
    var total = 0L
    while (pq.isNotEmpty()) {
        val target = pq.poll()
        if (find(target.to) != find(target.from)) {
            total += target.weight
            total += t * cnt
            cnt++
            union(target.to, target.from)
        }
    }

    println(total)
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
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