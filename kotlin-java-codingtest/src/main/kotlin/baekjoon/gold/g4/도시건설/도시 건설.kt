package baekjoon.gold.g4.도시건설

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

data class Node(var from: Int, var to: Int, var weight: Long) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return (this.weight - other.weight).toInt()
    }
}

lateinit var parent: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    parent = Array(n + 1) { it }

    val pq = PriorityQueue<Node>()

    var sum = 0L

    repeat(m) {
        val st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val weight = st.nextToken().toLong()

        pq.add(Node(from, to, weight))
        sum += weight
    }

    var total = 0L

    while (pq.isNotEmpty()) {
        val target = pq.poll()

        if(find(target.from) != find(target.to)) {
            total += target.weight
            union(target.from, target.to)
        }
    }

    val firstParent = find(1)


    for(i in 2 .. n) {
        if(firstParent != find(i)) {
            println(-1)
            return
        }
    }

    println(sum - total)
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
