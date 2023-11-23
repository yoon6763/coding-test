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
        val (cmd, v1, v2) = Array(3) { st.nextToken().toInt() }

        when (cmd) {
            1 -> {
                val color = st.nextToken().toInt()
                paint(v1, v2, color)
            }
            2 -> move(v1, v2)
            3 -> sb.appendLine(count(v1, v2))
        }
    }

    print(sb)
}

fun LCA(v1: Int, v2: Int): Int {
    val visited = BooleanArray(n)
    var cur = v1

    for (i in 0 until 1000) {
        visited[cur] = true
        cur = nodes[cur].parent

        if (cur == -1) break
    }

    cur = v2
    for (i in 0 until 1000) {
        if (visited[cur]) return cur
        cur = nodes[cur].parent

        if (cur == -1) break
    }

    return -1
}

fun paint(v1: Int, v2: Int, color: Int) {
    val foundLCA = LCA(v1, v2)

    if (foundLCA == -1) return

    var cur = v1
    while (cur != foundLCA) {
        nodes[cur].color = color
        cur = nodes[cur].parent
    }

    cur = v2
    while (cur != foundLCA) {
        nodes[cur].color = color
        cur = nodes[cur].parent
    }
}


fun count(v1: Int, v2: Int): Int {
    val foundLCA = LCA(v1, v2)
    val colorSet = HashSet<Int>()

    var cur = v1
    while (cur != foundLCA) {
        colorSet.add(nodes[cur].color)
        cur = nodes[cur].parent
    }

    cur = v2
    while (cur != foundLCA) {
        colorSet.add(nodes[cur].color)
        cur = nodes[cur].parent
    }

    return colorSet.size
}

fun move(v1: Int, v2: Int) {
    nodes[v1].parent = v2
}