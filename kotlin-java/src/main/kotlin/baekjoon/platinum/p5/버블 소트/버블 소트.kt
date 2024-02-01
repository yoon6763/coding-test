package baekjoon.platinum.p5.`버블 소트`

import java.util.StringTokenizer

lateinit var origin: LongArray
lateinit var sorted: LongArray
var ans = 0L

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    origin = LongArray(n) { st.nextToken().toLong() }
    sorted = LongArray(n)

    divide(0, n - 1)
    println(ans)
}

fun divide(low: Int, high: Int) {
    if (low == high) return
    val mid = (low + high) / 2
    divide(low, mid)
    divide(mid + 1, high)
    merge(low, mid, high)
}

fun merge(low: Int, mid: Int, high: Int) {
    var lo = low
    var hi = mid + 1
    var idx = low

    while (lo <= mid && hi <= high) {
        if (origin[lo] <= origin[hi]) {
            sorted[idx++] = origin[lo++]
        } else {
            sorted[idx++] = origin[hi++]
            ans += mid - lo + 1
        }
    }

    while (lo <= mid) sorted[idx++] = origin[lo++]
    while (hi <= high) sorted[idx++] = origin[hi++]
    for (i in low..high) origin[i] = sorted[i]
}