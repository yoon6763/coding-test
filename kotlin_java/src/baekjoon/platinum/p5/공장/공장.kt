package baekjoon.platinum.p5.`공장`

import java.util.*

lateinit var tree: LongArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var st = StringTokenizer(readLine())
    val up = IntArray(n + 1)
    for (i in 1..n) {
        up[i] = st.nextToken().toInt()
    }

    st = StringTokenizer(readLine())
    val down = HashMap<Int, Int>()
    for (i in 1..n) {
        down[st.nextToken().toInt()] = i
    }

    tree = LongArray(n * 4)

    var answer = 0L
    for (i in 1..n) {
        val upNumber = up[i]
        val downNumber = down[upNumber]

        answer += sum(1, n, 1, downNumber!! + 1, n)
        update(1, n, 1, downNumber, 1)
    }

    println(answer)
}

fun sum(start: Int, end: Int, node: Int, left: Int, right: Int): Long {
    if (right < start || end < left) return 0
    if (left <= start && end <= right) return tree[node]
    val mid = (start + end) / 2
    return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right)
}

fun update(start: Int, end: Int, node: Int, idx: Int, diff: Long) {
    if (idx < start || idx > end) return
    tree[node] += diff

    if (start != end) {
        val mid = (start + end) / 2
        update(start, mid, node * 2, idx, diff)
        update(mid + 1, end, node * 2 + 1, idx, diff)
    }
}