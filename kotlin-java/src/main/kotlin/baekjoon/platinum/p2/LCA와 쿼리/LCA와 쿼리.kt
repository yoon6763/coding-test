package baekjoon.platinum.p2.`LCA와 쿼리`

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.ceil
import kotlin.math.ln
import kotlin.math.pow

lateinit var list: Array<ArrayList<Int>>
lateinit var depth: IntArray
lateinit var parents: Array<IntArray>
var height = 0

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    list = Array(n + 1) { ArrayList() }

    repeat(n - 1) {
        val st = StringTokenizer(readLine())
        val (v1, v2) = listOf(st.nextToken().toInt(), st.nextToken().toInt())
        list[v1].add(v2)
        list[v2].add(v1)
    }

    height = ceil(ln(n.toDouble()) / ln(2.0)).toInt() + 1
    parents = Array(n + 1) { IntArray(height) }
    depth = IntArray(n + 1)

    setTree(1, 0)

    for (i in 1 until height) {
        for (j in 1 until n + 1) {
            parents[j][i] = parents[parents[j][i - 1]][i - 1]
        }
    }

    val sb = StringBuilder()
    val m = readLine().toInt()
    repeat(m) {
        val st = StringTokenizer(readLine())
        val (r, a, b) = listOf(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
        val raLCA = LCA(r, a)
        val rbLCA = LCA(r, b)
        val abLCA = LCA(a, b)

        when {
            raLCA == rbLCA -> sb.appendLine(abLCA)
            raLCA == abLCA -> sb.appendLine(rbLCA)
            rbLCA == abLCA -> sb.appendLine(raLCA)
        }
    }
    print(sb)
}

fun LCA(v1: Int, v2: Int): Int {
    var v1 = v1
    var v2 = v2
    val depth1 = depth[v1]
    val depth2 = depth[v2]

    if (depth1 < depth2) {
        val tmp = v1
        v1 = v2
        v2 = tmp
    }

    for (i in height - 1 downTo 0) {
        if (2.0.pow(i.toDouble()) <= depth[v1] - depth[v2]) {
            v1 = parents[v1][i]
        }
    }

    if (v1 == v2) return v1

    for (i in height - 1 downTo 0) {
        if (parents[v1][i] != parents[v2][i]) {
            v1 = parents[v1][i]
            v2 = parents[v2][i]
        }
    }

    return parents[v1][0]
}

fun setTree(idx: Int, parent: Int) {
    list[idx].forEach { next ->
        if (next == parent) return@forEach
        depth[next] = depth[idx] + 1
        setTree(next, idx)
        parents[next][0] = idx
    }
}