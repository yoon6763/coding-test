package baekjoon.gold.g4.`CTP 왕국은 한솔 왕국을 이길 수 있을까`

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    parent = IntArray(n + 1) { it }

    repeat(m) {
        val (v1, v2) = readLine().split(" ").map { it.toInt() }
        union(v1, v2)
    }

    val (c, h, k) = readLine().split(" ").map { it.toInt() }
    val rootOfHansol = find(h)
    val rootOfCTP = find(c)
    val ableCooperateRoots = HashMap<Int, Int>()
    var power = 0

    for (i in 1..n) {
        val root = find(i)
        if (root == rootOfCTP) {
            power++
            continue
        }
        if (root == rootOfHansol) continue
        ableCooperateRoots[root] = ableCooperateRoots.getOrDefault(root, 0) + 1
    }

    println(power + ableCooperateRoots.toList().sortedBy { -it.second }.slice(0..<k).sumOf { it.second })
}

fun find(x: Int): Int {
    if (x == parent[x]) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int) {
    val (px, py) = find(x) to find(y)
    if (px != py) parent[py] = px
}