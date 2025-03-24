package baekjoon.gold.g1.`수열과 쿼리 17`

import java.util.StringTokenizer

lateinit var tree: Array<Int>
lateinit var arr: Array<Int>

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var st = StringTokenizer(readLine())

    arr = Array(n + 1) { if (it == 0) 0 else st.nextToken().toInt() }
    tree = Array(n * 4) { 0 }

    init(1, n, 1)

    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        st = StringTokenizer(readLine())

        val (queryType, n1, n2) = Array(3) { st.nextToken().toInt() }
        if (queryType == 1) update(1, n, 1, n1, n2)
        else sb.append(query(1, n, 1, n1, n2)).append("\n")
    }
    print(sb)
}

fun init(start: Int, end: Int, node: Int): Int {
    if (start == end) {
        tree[node] = arr[start]
        return tree[node]
    }

    val mid = (start + end) / 2
    tree[node] = minOf(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1))
    return tree[node]
}

fun update(start: Int, end: Int, node: Int, idx: Int, value: Int): Int {
    if (idx !in start..end) return tree[node]
    if (start == end) {
        tree[node] = value
        return tree[node]
    }

    val mid = (start + end) / 2

    tree[node] = minOf(update(start, mid, node * 2, idx, value), update(mid + 1, end, node * 2 + 1, idx, value))
    return tree[node]
}

fun query(start: Int, end: Int, node: Int, left: Int, right: Int): Int {
    if (left > end || right < start) return Int.MAX_VALUE
    if (left <= start && end <= right) return tree[node]
    val mid = (start + end) / 2
    return minOf(query(start, mid, node * 2, left, right), query(mid + 1, end, node * 2 + 1, left, right))
}