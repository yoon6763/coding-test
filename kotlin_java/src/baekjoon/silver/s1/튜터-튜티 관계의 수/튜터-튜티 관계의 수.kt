package baekjoon.silver.s1.`튜터-튜티 관계의 수`

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    parent = IntArray(n + 1) { it }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        union(a, b)
    }

    val map = HashMap<Int, Int>()
    for (i in 1..n) {
        val p = find(i)
        map[p] = map.getOrDefault(p, 0) + 1
    }

    println(map.values.fold(1L) { acc, value -> (acc * value) % 1000000007 })
}

fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int) {
    val (px, py) = listOf(find(x), find(y))
    if (px == py) return
    parent[py] = px
}