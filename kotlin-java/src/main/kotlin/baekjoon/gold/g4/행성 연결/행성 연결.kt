package baekjoon.gold.g4.`행성 연결`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

data class Planet(var from: Int, var to: Int, var weight: Long) : Comparable<Planet> {
    override fun compareTo(other: Planet): Int {
        return (this.weight - other.weight).toInt()
    }
}

lateinit var parent: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val weight = Array(n) { Array(n) { 0L } }
    parent = Array(n) { it }

    val pq = PriorityQueue<Planet>()

    repeat(n) { x ->
        val st = StringTokenizer(br.readLine())
        repeat(n) { y ->
            weight[x][y] = st.nextToken().toLong()
            if (x != y) {
                pq.add(Planet(x, y, weight[x][y]))
            }
        }
    }
    var total = 0L

    while (pq.isNotEmpty()) {
        val target = pq.poll()

        if (find(target.to) != find(target.from)) {
            union(target.to, target.from)
            total += target.weight
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