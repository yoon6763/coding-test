package baekjoon.gold.g1.최솟값과최댓값

import kotlin.math.max
import kotlin.math.min

lateinit var arr: Array<Long>
lateinit var maxTree: Array<Long>
lateinit var minTree: Array<Long>

fun main() = with(System.`in`.bufferedReader()) {

    val (n, m) = readLine().split(" ").map { it.toInt() }

    arr = Array(n + 1) { if (it == 0) 0L else readLine().toLong() }

    maxTree = Array(n * 4 + 1) { 0L }
    minTree = Array(n * 4 + 1) { 0L }

    maxInit(1, n, 1)
    minInit(1, n, 1)

    val sb = StringBuilder()

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        sb.append(getMin(1, n, 1, a, b)).append(" ").append(getMax(1, n, 1, a, b)).append("\n")
    }
    print(sb)
}

fun maxInit(start: Int, end: Int, node: Int): Long {
    if (start == end) {
        maxTree[node] = arr[start]
        return maxTree[node]
    }
    val mid = (start + end) / 2
    maxTree[node] = max(maxInit(start, mid, node * 2), maxInit(mid + 1, end, node * 2 + 1))
    return maxTree[node]
}

fun minInit(start: Int, end: Int, node: Int): Long {
    if (start == end) {
        minTree[node] = arr[start]
        return minTree[node]
    }
    val mid = (start + end) / 2
    minTree[node] = min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1))
    return minTree[node]
}


fun getMax(start: Int, end: Int, node: Int, left: Int, right: Int): Long {
    if (left > end || right < start) return 0
    if (left <= start && end <= right) return maxTree[node]
    val mid = (start + end) / 2
    return max(getMax(start, mid, node * 2, left, right), getMax(mid + 1, end, node * 2 + 1, left, right))
}

fun getMin(start: Int, end: Int, node: Int, left: Int, right: Int): Long {
    if (left > end || right < start) return Long.MAX_VALUE
    if (left <= start && end <= right) return minTree[node]
    val mid = (start + end) / 2
    return min(getMin(start, mid, node * 2, left, right), getMin(mid + 1, end, node * 2 + 1, left, right))
}