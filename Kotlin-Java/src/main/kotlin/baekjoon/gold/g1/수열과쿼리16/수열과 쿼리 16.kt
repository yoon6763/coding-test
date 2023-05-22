package baekjoon.gold.g1.수열과쿼리16

import java.util.*

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


fun init(start: Int, end: Int, node: Int) {
    if (start == end) tree[node] = start
    else {
        val mid = (start + end) / 2
        init(start, mid, node * 2)
        init(mid + 1, end, node * 2 + 1)

        if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) tree[node] = tree[node * 2]
        else tree[node] = tree[node * 2 + 1]
    }
}

fun update(start: Int, end: Int, node: Int, idx: Int, value: Int) {
    if (idx < start || idx > end) return

    if (start == end) {
        tree[node] = idx
        arr[idx] = value
        return
    }

    val mid = (start + end) / 2

    update(start, mid, node * 2, idx, value)
    update(mid + 1, end, node * 2 + 1, idx, value)

    if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
        tree[node] = tree[node * 2]
    } else {
        tree[node] = tree[node * 2 + 1]
    }
}


fun query(start: Int, end: Int, node: Int, left: Int, right: Int): Int {
    if (left > end || right < start) return -1
    if (left <= start && end <= right) return tree[node]

    val mid = (start + end) / 2
    val middle1 = query(start, mid, node * 2, left, right)
    val middle2 = query(mid + 1, end, node * 2 + 1, left, right)

    return if (middle1 == -1) middle2
    else if (middle2 == -1) middle1
    else if (arr[middle1] <= arr[middle2]) middle1
    else middle2
}