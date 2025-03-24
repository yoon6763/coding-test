package baekjoon.platinum.p5.한동이는_영업사원

lateinit var connected: Array<ArrayList<Int>>
lateinit var depths: IntArray
lateinit var parents: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    connected = Array(n + 1) { ArrayList() }
    depths = IntArray(n + 1) { 0 }
    parents = IntArray(n + 1) { 0 }

    repeat(n - 1) {
        val (v1, v2) = readLine().split(" ").map { it.toInt() }
        connected[v1].add(v2)
        connected[v2].add(v1)
    }

    dfs(1, 0, 1)

    val m = readLine().toInt()
    var ans = 0
    var city = readLine().toInt()

    repeat(m - 1) {
        val nextCity = readLine().toInt()
        ans += depths[city] + depths[nextCity] - 2 * depths[LCA(city, nextCity)]
        city = nextCity
    }

    println(ans)
}

fun dfs(cur: Int, depth: Int, parent: Int) {
    depths[cur] = depth
    parents[cur] = parent

    connected[cur].forEach { next ->
        if (parent == next) return@forEach
        dfs(next, depth + 1, cur)
    }
}

fun LCA(v1: Int, v2: Int): Int {
    if (v1 == 1 || v2 == 1) return 1

    var v1 = v1
    var v2 = v2

    var depth1 = depths[v1]
    var depth2 = depths[v2]

    while (depth1 > depth2) {
        depth1--
        v1 = parents[v1]
    }

    while (depth1 < depth2) {
        depth2--
        v2 = parents[v2]
    }

    while (v1 != v2) {
        v1 = parents[v1]
        v2 = parents[v2]
    }

    return v1
}