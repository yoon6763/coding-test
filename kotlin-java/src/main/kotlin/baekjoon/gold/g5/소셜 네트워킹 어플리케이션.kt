package baekjoon.gold.g5

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val k = readLine().toInt()
        parent = IntArray(n + 1) { it }

        repeat(k) {
            val (x, y) = readLine().split(" ").map(String::toInt)
            union(x, y)
        }
        sb.appendLine("Scenario ${it + 1}:")

        repeat(readLine().toInt()) {
            val (x, y) = readLine().split(" ").map(String::toInt)
            sb.appendLine(if (find(x) == find(y)) 1 else 0)
        }
        sb.appendLine()
    }
    print(sb)
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