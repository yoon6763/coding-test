package baekjoon.gold.g4.최단경로

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

data class Node(var vertex: Int, var weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }
}

var v = 0
var e = 0
lateinit var con: Array<ArrayList<Node>>
lateinit var dis: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val ve = br.readLine().split(" ")
    v = ve[0].toInt()
    e = ve[1].toInt()

    val startNode = br.readLine().toInt()

    con = Array(v + 1) { ArrayList() }
    dis = Array(v + 1) { Int.MAX_VALUE }
    dis[startNode] = 0

    for (i in 0 until e) {
        val uvw = br.readLine().split(" ")
        val u = uvw[0].toInt()
        val v = uvw[1].toInt()
        val w = uvw[2].toInt()
        con[u].add(Node(v, w))
    }

    dijkstra(startNode)

    for (i in 1..v) {
        println(if (dis[i] == Int.MAX_VALUE) "INF" else dis[i])
    }
}

fun dijkstra(startNode: Int) {
    val pq = PriorityQueue<Node>()
    pq.offer(Node(startNode, 0))

    while (pq.isNotEmpty()) {
        val target = pq.poll()

        if (dis[target.vertex] < target.weight) continue

        for (i in 0 until con[target.vertex].size) {
            val target2 = con[target.vertex][i]
            val nWeight = target.weight + target2.weight

            if (dis[target2.vertex] > nWeight) {
                dis[target2.vertex] = nWeight
                pq.offer(Node(target2.vertex, nWeight))
            }
        }
    }
}