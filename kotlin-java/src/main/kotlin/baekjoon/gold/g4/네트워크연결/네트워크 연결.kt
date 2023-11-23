package baekjoon.gold.g4.네트워크연결

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer


data class Node(var from: Int, var to: Int, var weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.weight - other.weight
    }
}

lateinit var parent: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt() // 컴퓨터의 수
    val m = br.readLine().toInt() // 연결할 수 있는 선의 수

    parent = Array(n + 1) { it }

    val pq = PriorityQueue<Node>()

    repeat(m) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val w = st.nextToken().toInt()

        pq.add(Node(a, b, w))
    }

    var total = 0

    while (pq.isNotEmpty()) {
        val target = pq.poll()

        if (find(target.from) != find(target.to)) {
            union(target.from, target.to)
            total += target.weight
        }
    }

    println(total)
}

fun union(x: Int, y: Int) {
    val nx = find(x)
    val ny = find(y)
    if (nx != ny) {
        parent[ny] = nx
    }
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}