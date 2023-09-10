package baekjoon.gold.g1.수들의합7

import java.util.*

lateinit var tree: LongArray

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val (n, m) = Array(2) { st.nextToken().toInt() }
    tree = LongArray(n * 4)

    val sb = StringBuilder()
    repeat(m) {
        st = StringTokenizer(readLine())
        var (cmd, n1, n2) = Array(3) { st.nextToken().toInt() }

        if (cmd == 0) {
            if (n1 > n2) {
                val temp = n1
                n1 = n2
                n2 = temp
            }
            sb.append(sum(1, n, 1, n1, n2)).append("\n")
        } else update(1, n, 1, n1, n2)
    }

    print(sb)
}

fun sum(start: Int, end: Int, node: Int, left: Int, right: Int): Long {
    if (left > end || right < start) return 0
    if (left <= start && end <= right) return tree[node]

    val mid = (start + end) / 2
    return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right)
}

fun update(start: Int, end: Int, node: Int, idx: Int, value: Int): Long {
    if (idx < start || idx > end) return tree[node]
    if (start == end) {
        tree[node] = value.toLong()
        return tree[node]
    }
    val mid = (start + end) / 2

    tree[node] = update(start, mid, node * 2, idx, value) + update(mid + 1, end, node * 2 + 1, idx, value)
    return tree[node]
}
