package baekjoon.platinum.p5.`중앙값`

lateinit var tree: IntArray
lateinit var arr: IntArray
const val MAX = 65537

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    tree = IntArray(MAX * 4)
    arr = IntArray(n + 1)
    var ans = 0L

    for (i in 1..n) {
        arr[i] = readLine().toInt()
        update(0, MAX, 1, arr[i], 1)
        if (i >= k) {
            val query = query(0, MAX, 1, (k + 1) / 2)
            ans += query
            update(0, MAX, 1, arr[i - k + 1], -1)
        }
    }

    println(ans)
}

fun update(start: Int, end: Int, node: Int, index: Int, value: Int) {
    if (index < start || end < index) return
    tree[node] += value
    if (start == end) return

    val mid = (start + end) / 2
    update(start, mid, node * 2, index, value)
    update(mid + 1, end, node * 2 + 1, index, value)
}

fun query(start: Int, end: Int, node: Int, count: Int): Int {
    if (start == end) return start
    val mid = (start + end) / 2
    return if (tree[node * 2] >= count) query(start, mid, node * 2, count)
    else query(mid + 1, end, node * 2 + 1, count - tree[node * 2])
}
