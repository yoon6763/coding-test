package baekjoon.gold.g1.`가계부 (Hard)`

import java.util.StringTokenizer

var n = 0
lateinit var tree: Array<Long>

fun main() = with(System.`in`.bufferedReader()) {
    val nq = readLine().split(" ").map { it.toInt() }
    n = nq[0]
    val q = nq[1]

    tree = Array(n + 1) { 0L }

    val sb = StringBuilder()
    repeat(q) {
        val st = StringTokenizer(readLine())
        val (op, a, b) = List(3) { st.nextToken().toInt() }
        when (op) {
            1 -> update(a, b.toLong())
            2 -> sb.appendLine(sum(b) - sum(a - 1))
        }
    }
    print(sb)
}

fun update(idx: Int, value: Long) {
    var idx = idx
    while (idx <= n) {
        tree[idx] += value
        idx += (idx and -idx)
    }
}

fun sum(idx: Int): Long {
    var idx = idx
    var result = 0L
    while (idx > 0) {
        result += tree[idx]
        idx -= (idx and -idx)
    }
    return result
}