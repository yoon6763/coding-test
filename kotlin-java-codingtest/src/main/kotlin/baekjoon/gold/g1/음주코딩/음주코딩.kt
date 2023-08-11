package baekjoon.gold.g1.음주코딩

import java.util.StringTokenizer

lateinit var tree: Array<Int>
lateinit var arr: Array<Int>

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    var st: StringTokenizer

    while (true) {
        val line: String? = readLine()
        if (line == null || line == "") break

        val (n, k) = line.split(" ").map { it.toInt() }
        arr = Array(n + 1) { 0 }
        tree = Array(n * 4) { 0 }

        st = StringTokenizer(readLine())
        for (i in 1..n) {
            val num = st.nextToken().toInt()
            when {
                num > 0 -> arr[i] = 1
                num < 0 -> arr[i] = -1
                else -> arr[i] = 0
            }
        }

        init(1, n, 1)

        repeat(k) {
            st = StringTokenizer(readLine())
            when (st.nextToken()) {
                "C" -> {
                    val i = st.nextToken().toInt()
                    var v = st.nextToken().toInt()
                    v = when {
                        v > 0 -> 1
                        v < 0 -> -1
                        else -> 0
                    }
                    update(1, n, 1, i, v)
                }

                "P" -> {
                    val i = st.nextToken().toInt()
                    val j = st.nextToken().toInt()
                    val result = query(1, n, 1, i, j)
                    when {
                        result > 0 -> sb.append("+")
                        result < 0 -> sb.append("-")
                        else -> sb.append("0")
                    }
                }
            }
        }
        sb.append("\n")
    }

    print(sb)
}

fun init(start: Int, end: Int, node: Int) {
    if (start == end) {
        tree[node] = arr[start]
        return
    }

    val mid = (start + end) / 2
    init(start, mid, node * 2)
    init(mid + 1, end, node * 2 + 1)
    tree[node] = tree[node * 2] * tree[node * 2 + 1]
}

fun update(start: Int, end: Int, node: Int, index: Int, value: Int) {
    if (index < start || index > end) return
    if (start == end) {
        tree[node] = value
        return
    }

    val mid = (start + end) / 2
    update(start, mid, node * 2, index, value)
    update(mid + 1, end, node * 2 + 1, index, value)
    tree[node] = tree[node * 2] * tree[node * 2 + 1]
}

fun query(start: Int, end: Int, node: Int, left: Int, right: Int): Int {
    if (left > end || right < start) return 1
    if (left <= start && end <= right) return tree[node]

    val mid = (start + end) / 2
    return query(start, mid, node * 2, left, right) * query(mid + 1, end, node * 2 + 1, left, right)
}