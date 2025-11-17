package baekjoon.platinum.p3

data class Edge(val from: Int, val to: Int, val weight: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return weight - other.weight
    }
}

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        val (n, m, k) = readLine().split(" ").map(String::toInt)

        if (n == 0 && m == 0 && k == 0) break

        parent = IntArray(n + 1) { it }
        val edges = mutableListOf<Edge>()
        repeat(m) {
            val (type, from, to) = readLine().split(" ")
            edges.add(Edge(from.toInt(), to.toInt(), if (type == "R") 0 else 1))
        }

        edges.sort()

        var min = 0
        edges.forEach { edge ->
            if (union(edge.from, edge.to)) min += edge.weight
        }

        parent = IntArray(n + 1) { it }
        var max = 0
        edges.reversed().forEach { edge ->
            if (union(edge.from, edge.to)) max += edge.weight
        }

        sb.append(if (k in min..max) 1 else 0).append("\n")
    }

    print(sb)
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val (px, py) = find(x) to find(y)
    return if (px == py) false
    else {
        parent[px] = py
        true
    }
}