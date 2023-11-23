package baekjoon.gold.g3.별자리만들기

import java.util.PriorityQueue
import kotlin.math.pow
import kotlin.math.sqrt

data class Node(val from: Int, val to: Int, val weight: Double) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return if(this.weight > other.weight) 1 else -1
    }
}

data class Star(var x: Double, var y: Double)

var total = 0.0
lateinit var parent: Array<Int>

fun main() {
    val n = readLine()!!.toInt()
    parent = Array(n + 1) { it }

    val stars = Array<Star>(n) { Star(0.0, 0.0) }

    val pq = PriorityQueue<Node>()

    for (i in 0 until n) {
        val line = readLine()!!.split(" ")
        stars[i].x = line[0].toDouble()
        stars[i].y = line[1].toDouble()

        for (j in 0 until i) {
            val weight = sqrt((stars[i].x - stars[j].x).pow(2) + (stars[i].y - stars[j].y).pow(2))
            pq.add(Node(i, j, weight))
        }
    }

    while(pq.isNotEmpty()) {
        val node = pq.poll()

        if (find(node.from) != find(node.to)) {
            total += node.weight
            union(node.from, node.to)
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
        if(x < y) {
            parent[ny] = nx
        } else {
            parent[nx] = ny
        }
    }
}