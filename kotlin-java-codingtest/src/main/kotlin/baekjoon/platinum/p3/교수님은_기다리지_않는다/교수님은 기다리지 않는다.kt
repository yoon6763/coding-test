package baekjoon.platinum.p3.교수님은_기다리지_않는다

import java.lang.StringBuilder
import java.util.StringTokenizer

lateinit var parents: IntArray
lateinit var weights: IntArray

fun main() = with(System.`in`.bufferedReader()) {

    val sb = StringBuilder()

    while (true) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break

        parents = IntArray(n + 1) { it }
        weights = IntArray(n + 1) { 0 }

        repeat(m) {
            val st = StringTokenizer(readLine())
            val cmd = st.nextToken()

            if (cmd == "!") {
                val (m1, m2, weight) = List(3) { st.nextToken().toInt() }
                union(m1, m2, weight)
            } else {
                val (m1, m2) = List(2) { st.nextToken().toInt() }
                if (find(m1) != find(m2)) {
                    sb.appendLine("UNKNOWN")
                    return@repeat
                }
                sb.appendLine(weights[m2] - weights[m1])
            }
        }
    }

    print(sb)
}

fun find(x: Int): Int {
    return if (x == parents[x]) x
    else {
        val parent = find(parents[x])
        weights[x] += weights[parents[x]]
        parents[x] = parent
        parent
    }
}

fun union(x: Int, y: Int, weight: Int) {
    val (px, py) = find(x) to find(y)

    if (px == py) return

    parents[py] = px
    weights[py] = weights[x] - weights[y] + weight
}