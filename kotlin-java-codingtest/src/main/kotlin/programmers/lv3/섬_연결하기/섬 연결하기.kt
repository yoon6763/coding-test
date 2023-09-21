package programmers.lv3.섬_연결하기

data class Edge(val from: Int, val to: Int, val cost: Int)

lateinit var parent: IntArray

fun solution(n: Int, costs: Array<IntArray>): Int {
    parent = IntArray(n) { it }
    var answer = 0

    val edges = mutableListOf<Edge>()
    costs.forEach { (from, to, cost) -> edges.add(Edge(from, to, cost)) }
    edges.sortedBy { it.cost }.forEach { (from, to, cost) -> if (union(from, to)) answer += cost }

    return answer
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val (nx, ny) = find(x) to find(y)
    return if (nx == ny) false
    else {
        parent[nx] = ny
        true
    }
}