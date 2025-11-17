package baekjoon.gold.g3.`나만 안되는 연애`

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
    // 학교의 수, 도로의 수
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val st = StringTokenizer(br.readLine())
    // 남초일 경우 true
    val isManUniv = Array(n + 1) { false }
    for (i in 1..n) {
        if (st.nextToken() == "M") isManUniv[i] = true
    }
    parent = Array(n + 1) { it }

    val pq = PriorityQueue<Node>()

    repeat(m) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val w = st.nextToken().toLong()
        if (isManUniv[a] != isManUniv[b]) {
            pq.offer(Node(a, b, w))
        }
    }
    var cnt = 0
    var total = 0L
    while (pq.isNotEmpty()) {
        val target = pq.poll()
        if (find(target.to) != find(target.from)) {
            cnt++
            union(target.to, target.from)
            total += target.weight
        }
    }

    println(if (cnt != n - 1) -1 else total)
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