package baekjoon.silver.s2.`연산자 끼워넣기 (2)`

lateinit var arr: List<Int>
lateinit var op: Array<Int>

var max = Int.MIN_VALUE
var min = Int.MAX_VALUE
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = readLine().split(" ").map { it.toInt() }
    op = readLine().split(" ").map { it.toInt() }.toTypedArray()

    solve(0, arr[0])
    println(max)
    println(min)
}

fun solve(depth: Int, sum: Int) {
    if (depth == n - 1) {
        max = max.coerceAtLeast(sum)
        min = min.coerceAtMost(sum)
        return
    }

    for (i in 0..<4) {
        if (op[i] <= 0) continue
        op[i]--
        when (i) {
            0 -> solve(depth + 1, sum + arr[depth + 1])
            1 -> solve(depth + 1, sum - arr[depth + 1])
            2 -> solve(depth + 1, sum * arr[depth + 1])
            3 -> solve(depth + 1, sum / arr[depth + 1])
        }
        op[i]++
    }

}