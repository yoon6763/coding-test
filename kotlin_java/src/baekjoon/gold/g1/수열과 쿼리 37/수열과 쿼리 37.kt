package baekjoon.gold.g1.`수열과 쿼리 37`

import java.util.StringTokenizer

var n = 0
lateinit var arr: IntArray
lateinit var tree: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    var st = StringTokenizer("0 ${readLine()}")
    arr = IntArray(n + 1) { st.nextToken().toInt() }
    tree = IntArray(n * 4) { 0 }

    init(1, n, 1)

    val m = readLine().toInt()
    val sb = StringBuilder()
    repeat(m) {
        st = StringTokenizer(readLine())
        val (cmd, a, b) = Array(3) { st.nextToken().toInt() }

        when (cmd) {
            1 -> {
                if (arr[a] % 2 == 0 && b % 2 == 1) update(1, n, 1, a, 0)
                else if (arr[a] % 2 == 1 && b % 2 == 0) update(1, n, 1, a, 1)

                arr[a] = b
            }

            2 -> sb.append(query(1, n, 1, a, b)).append("\n")
            3 -> sb.append(b - a + 1 - query(1, n, 1, a, b)).append("\n")
        }
    }

    print(sb)
}

fun init(start: Int, end: Int, node: Int): Int {
    if (start == end) {
        if (arr[start] % 2 == 0) {
            tree[node] = 1
            return 1
        }
        return 0
    }

    val mid = (start + end) / 2
    tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1)
    return tree[node]
}

fun update(start: Int, end: Int, node: Int, idx: Int, value: Int): Int {
    if (idx < start || idx > end) return tree[node]

    if (start == end) {
        tree[node] = value
        return value
    }

    val mid = (start + end) / 2
    tree[node] = update(start, mid, node * 2, idx, value) + update(mid + 1, end, node * 2 + 1, idx, value)
    return tree[node]
}

fun query(start: Int, end: Int, node: Int, left: Int, right: Int): Int {
    if (left > end || right < start) return 0
    if (left <= start && end <= right) return tree[node]

    val mid = (start + end) / 2
    return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right)
}