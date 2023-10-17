package baekjoon.gold.g1.부분수열의합2

lateinit var arr: IntArray
var n = 0
var s = 0
var ans = 0L
val map = mutableMapOf<Int, Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val ns = readLine().split(" ").map { it.toInt() }
    n = ns[0]
    s = ns[1]

    arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    right(n / 2, 0)
    left(0, 0)

    if (s == 0) ans -= 1
    println(ans)
}

fun right(mid: Int, sum: Int) {
    if (mid == n) {
        map[sum] = map.getOrDefault(sum, 0) + 1
        return
    }

    right(mid + 1, sum)
    right(mid + 1, sum + arr[mid])
}

fun left(start: Int, sum: Int) {
    if (start == n / 2) {
        ans += map.getOrDefault(s - sum, 0)
        return
    }

    left(start + 1, sum)
    left(start + 1, sum + arr[start])
}