package baekjoon.gold.g5.`여러분의 다리가 되어 드리겠습니다`

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    parent = IntArray(n + 1) { it }
    repeat(n - 2) {
        val (x, y) = readLine().split(" ").map(String::toInt)
        union(x, y)
    }

    val root = find(1)
    for (i in 2..n) {
        if (root != find(i)) {
            println("$root $i")
            return
        }
    }
}

fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int) {
    val (px, py) = find(x) to find(y)
    if (px < py) parent[py] = px
    else parent[px] = py
}