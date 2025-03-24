package baekjoon.platinum.p5.`통신망 분할`

import java.util.*

class Node(var from: Int, var to: Int)

lateinit var parent: IntArray
lateinit var groupSize: LongArray
lateinit var connects: Array<Node>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, q) = readLine().split(" ").map { it.toInt() }

    parent = IntArray(n + 1) { it }
    groupSize = LongArray(n + 1) { 1 }
    connects = Array(m + 1) { Node(0, 0) }

    for (i in 1..m) {
        val (a, b) = StringTokenizer(readLine()).let { it.nextToken().toInt() to it.nextToken().toInt() }
        connects[i] = Node(a, b)
    }

    val cut = BooleanArray(m + 1)
    val query = Stack<Int>()

    repeat(q) {
        val disconnect = readLine().toInt()
        cut[disconnect] = true
        query.push(disconnect)
    }

    for (i in 1..m) {
        if (cut[i]) continue
        union(connects[i].from, connects[i].to)
    }

    var answer = 0L

    while (query.isNotEmpty()) {
        val cur = connects[query.pop()]
        val (rootFrom, rootTo) = find(cur.from) to find(cur.to)
        if (rootFrom != rootTo) {
            answer += groupSize[rootFrom] * groupSize[rootTo]
        }
        union(rootFrom, rootTo)
    }

    println(answer)
}

fun union(x: Int, y: Int) {
    var px = find(x)
    var py = find(y)

    if (px > py) {
        val temp = px
        px = py
        py = temp
    }

    if (px != py) {
        groupSize[px] += groupSize[py]
        parent[py] = px
    }
}

fun find(x: Int): Int {
    if (x == parent[x]) return x
    return find(parent[x]).also { parent[x] = it }
}