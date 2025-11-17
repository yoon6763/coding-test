package baekjoon.gold.g4.`로봇 조립`

import java.util.StringTokenizer

const val SIZE = 1000001
var parent = IntArray(SIZE) { it }
var component = IntArray(SIZE) { 1 }

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        when (st.nextToken()) {
            "I" -> {
                val (a, b) = List(2) { st.nextToken().toInt() }
                if (find(a) != find(b)) union(a, b)
            }

            "Q" -> {
                val a = st.nextToken().toInt()
                sb.appendLine(component[find(a)])
            }
        }
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
    if (px < py) {
        parent[py] = px
        component[px] += component[py]
        component[py] = 0
    } else {
        parent[px] = py
        component[py] += component[px]
        component[px] = 0
    }
}