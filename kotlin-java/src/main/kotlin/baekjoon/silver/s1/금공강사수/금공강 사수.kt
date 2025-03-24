package baekjoon.silver.s1.금공강사수

lateinit var arr: Array<IntArray>
val schedule = Array(6) { BooleanArray(11) }
var answer = 0
var n = 0
var k = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nk = readLine().split(" ").map { it.toInt() }
    n = nk[0]
    k = nk[1]

    arr = Array(n) {
        val (d, s, e) = readLine().split(" ").map { it.toInt() }
        intArrayOf(d, s, e, e - s + 1)
    }

    dfs(0, 0)
    print(answer)
}

fun dfs(idx: Int, score: Int) {
    if (k == score) {
        answer++
        return
    }

    if (idx == n) return

    for (i in idx..<n) {
        val (day, start, end, sc) = arr[i]
        if (day == 5 || (start..end).any { schedule[day][it] }) continue
        (start..end).forEach { j -> schedule[day][j] = true }
        dfs(i + 1, score + sc)
        (start..end).forEach { j -> schedule[day][j] = false }
    }
}