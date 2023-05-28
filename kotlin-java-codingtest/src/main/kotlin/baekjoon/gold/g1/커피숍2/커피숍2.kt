package baekjoon.gold.g1.커피숍2

import java.util.*


lateinit var arr: Array<Long>
lateinit var tree: Array<Long>

fun main() = with(System.`in`.bufferedReader()) {

    val (n, q) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(readLine())
    arr = Array(n + 1) { if (it == 0) 0L else st.nextToken().toLong() }
    tree = Array(n * 4 + 1) { 0 }

    init(1, n, 1)

    val sb = StringBuilder()

    repeat(q) {
        val st = StringTokenizer(readLine())
        val (x, y, a) = Array(3) { st.nextToken().toInt() }
        val b = st.nextToken().toLong()

        if (x < y) sb.append(sum(1, n, 1, x, y)).append("\n")
        else sb.append(sum(1, n, 1, y, x)).append("\n")

        update(1, n, 1, a, b)
    }
    print(sb)
}

fun init(start: Int, end: Int, node: Int): Long {
    if (start == end) {
        tree[node] = arr[start]
        return tree[node]
    }

    val mid = (start + end) / 2
    tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1)
    return tree[node]
}


fun sum(start: Int, end: Int, node: Int, left: Int, right: Int): Long {
    // 범위 밖
    if (left > end || right < start) return 0
    // 범위 안
    if (left <= start && end <= right) return tree[node]
    // 그렇지 않다면 두 부분으로 나눠 합 구하기
    val mid = (start + end) / 2
    return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right)
}

// index : 구간 합을 수정하고자 하느 노드
// dif : 수정할 값
fun update(start: Int, end: Int, node: Int, index: Int, value: Long): Long {
    if (index < start || index > end) return tree[node]
    if (start == end) {
        tree[node] = value
        return tree[node]
    }

    val mid = (start + end) / 2
    tree[node] = update(start, mid, node * 2, index, value) + update(mid + 1, end, node * 2 + 1, index, value)
    return tree[node]
}