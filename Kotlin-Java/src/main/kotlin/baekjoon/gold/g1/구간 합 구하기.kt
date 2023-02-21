package baekjoon.gold.g1

import java.util.*

lateinit var arr: Array<Long>
lateinit var tree: Array<Long>

fun main() = with(System.`in`.bufferedReader()) {
    // 수의 개수 m, 변경이 일어나는 횟수 m, 구간 합 구하는 횟수 k
    val (n, m, k) = readLine().split(" ").map { it.toInt() }

    // 첫 번째 값은 0으로 초기화
    arr = Array(n + 1) { if (it == 0) 0L else readLine().toLong() }
    tree = Array(n * 4 + 1) { 0L } // * 4 를 하면 모든 범위 커버 가능

    init(1, n, 1)

    val sb = StringBuilder()

    // 변경 및 합 출력
    repeat(m + k) {
        val st = StringTokenizer(readLine())
        // a, b, c
        // a - 1 : b를 c로 바꿔라
        // a - 2 : b 부터 c 까지 구간 합을 구하라
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        // Update
        if (a == 1) {
            val c = st.nextToken().toLong()
            val diff = c - arr[b] // 차이 값 구하기
            arr[b] = c.toLong() // b 값을 c로 변경
            update(1, n, 1, b, diff) // 차이 값 만큼 갱신
        } else {
            val c = st.nextToken().toInt()
            // Sum
            sb.append(sum(1, n, 1, b, c)).append("\n")
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
fun update(start: Int, end: Int, node: Int, index: Int, diff: Long) {
    // 범위 밖
    if (index < start || index > end) return
    tree[node] += diff
    if (start == end) return
    val mid = (start + end) / 2
    update(start, mid, node * 2, index, diff)
    update(mid + 1, end, node * 2 + 1, index, diff)
}