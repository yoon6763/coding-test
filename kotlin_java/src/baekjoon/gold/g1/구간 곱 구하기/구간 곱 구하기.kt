package baekjoon.gold.g1.`구간 곱 구하기`

import java.util.*

lateinit var arr: Array<Long>
lateinit var tree: Array<Long>
var MOD = 1000000007

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }

    arr = Array(n + 1) { if (it == 0) 1L else readLine().toLong() }
    tree = Array(n * 4 + 1) { 1L } // * 4 를 하면 모든 범위 커버 가능

    init(1, n, 1)

    val sb = StringBuilder()

    repeat(m + k) {
        val st = StringTokenizer(readLine())

        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        if (a == 1) {
            val c = st.nextToken().toLong()
            arr[b] = c
            update(1, n, 1, b, c)
        } else {
            val c = st.nextToken().toInt()
            sb.append(multi(1, n, 1, b, c)).append("\n")
        }
    }

    print(sb)
}


fun init(start: Int, end: Int, node: Int): Long {
    if (start == end) {
        tree[node] = arr[start]
        return tree[node]
    }

    val mid = (start + end) / 2
    tree[node] = init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1) % MOD
    return tree[node]
}


fun multi(start: Int, end: Int, node: Int, left: Int, right: Int): Long {
    // 범위 밖
    if (left > end || right < start) return 1
    // 범위 안
    if (left <= start && end <= right) return tree[node]
    // 그렇지 않다면 두 부분으로 나눠 합 구하기
    val mid = (start + end) / 2
    return multi(start, mid, node * 2, left, right) * multi(mid + 1, end, node * 2 + 1, left, right) % MOD
}

fun update(start: Int, end: Int, node: Int, index: Int, num: Long): Long {
    // 범위 밖
    if (index < start || index > end) return tree[node]
    if (start == end) {
        tree[node] = num
        return tree[node]
    }
    val mid = (start + end) / 2
    tree[node] = update(start, mid, node * 2, index, num) * update(mid + 1, end, node * 2 + 1, index, num) % MOD
    return tree[node]
}