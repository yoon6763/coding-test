package baekjoon.gold.g4.Networking

class Edge(val v1: Int, val v2: Int, val cost: Int)

lateinit var parent: IntArray

fun main() {
    while (true) {
        try {
            val (n, m) = readln().split(" ").map { it.toInt() }
            if (n == 1 || m == 0) {
                println(0)
                readln()
                continue
            }

            parent = IntArray(n + 1) { it }

            val edges = ArrayList<Edge>()

            repeat(m) {
                val (v1, v2, cost) = readln().split(" ").map { it.toInt() }
                edges.add(Edge(v1, v2, cost))
            }

            edges.sortBy { it.cost }

            var totalCost = 0

            edges.forEach { edge ->
                if (!union(edge.v1, edge.v2)) return@forEach
                totalCost += edge.cost
            }

            println(totalCost)
            readln()
        } catch (e: Exception) {
            break
        }
    }
}

fun find(x: Int): Int = if (parent[x] == x) x else find(parent[x]).also { parent[x] = it }
fun union(x: Int, y: Int) = find(x).let { px -> find(y).let { py -> (px != py).also { if (it) parent[px] = py } } }