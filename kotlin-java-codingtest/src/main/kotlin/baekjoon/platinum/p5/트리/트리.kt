package baekjoon.platinum.p5.트리

import java.util.StringTokenizer

data class Node(var parent: Int, var color: Int)

var n = 0
lateinit var nodes: Array<Node>

fun main() = with(System.`in`.bufferedReader()) {
    val nk = readLine().split(" ").map { it.toInt() }
    n = nk[0]
    val k = nk[1]

    nodes = Array(n) { Node(0, 0) }
    nodes[0].parent = -1

    val sb = StringBuilder()

    repeat(k) {
        val st = StringTokenizer(readLine())
        val (r, a, b) = Array(3) { st.nextToken().toInt() }

        when (r) {
            1 -> paint(a, b, st.nextToken().toInt())
            2 -> move(a, b)
            3 -> sb.appendLine(count(a, b))
        }
    }

    print(sb)
}

fun lca(a: Int, b: Int): Int {
    if (a == b) return a

    val visited = BooleanArray(n)
    var cur = a

    for (i in 0 until 1000) {
        visited[cur] = true
        cur = nodes[cur].parent

        if (cur == -1) break
    }

    cur = b
    for (i in 0 until 1000) {
        if (visited[cur]) return cur
        cur = nodes[cur].parent

        if (cur == -1) break
    }

    return -1
}

fun paint(a: Int, b: Int, color: Int) {
    val lca = lca(a, b)

    if (lca == -1) return

    var cur = a
    while (cur != lca) {
        nodes[cur].color = color
        cur = nodes[cur].parent
    }

    cur = b
    while (cur != lca) {
        nodes[cur].color = color
        cur = nodes[cur].parent
    }
}


fun count(a: Int, b: Int): Int {
    val lca = lca(a, b)

    val colorSet = HashSet<Int>()

    var cur = a
    while (cur != lca) {
        colorSet.add(nodes[cur].color)
        cur = nodes[cur].parent
    }

    cur = b
    while (cur != lca) {
        colorSet.add(nodes[cur].color)
        cur = nodes[cur].parent
    }

    return colorSet.size
}

fun move(a: Int, b: Int) {
    nodes[a].parent = b
}