package baekjoon.gold.g1.최솟값

import java.util.*
import kotlin.math.min

lateinit var arr: Array<Long>
lateinit var tree: Array<Long>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    arr = Array(n + 1) { if (it == 0) 0L else readLine().toLong() }
    tree = Array(n * 4 + 1) { 0L } // * 4를 하여 모든 범위 커버

    init(1, n, 1)

    val sb = StringBuilder()

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (a, b) = Array(2) { st.nextToken().toInt() }

        sb.append(getMin(1, n, 1, a, b)).append("\n")
    }
    print(sb)
}


fun init(start: Int, end: Int, node: Int): Long {
    if (start == end) {
        tree[node] = arr[start]
        return tree[node]
    }
    val mid = (start + end) / 2
    tree[node] = min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1))
    return tree[node]
}

fun getMin(start: Int, end: Int, node: Int, left: Int, right: Int): Long {
    if (left > end || right < start) return Long.MAX_VALUE
    if (left <= start && end <= right) return tree[node]
    val mid = (start + end) / 2
    return min(
        getMin(start, mid, node * 2, left, right),
        getMin(mid + 1, end, node * 2 + 1, left, right)
    )
}