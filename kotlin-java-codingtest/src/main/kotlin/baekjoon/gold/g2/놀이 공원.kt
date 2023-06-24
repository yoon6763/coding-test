package baekjoon.gold.g2

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ")
    val n = nm[0].toLong()
    val m = nm[1].toInt()

    val st = StringTokenizer(readLine())
    val arr = Array(m) { st.nextToken().toLong() }


    if (n <= m) {
        println(n)
        return
    }

    var l = 0L
    var r = n / m * arr.maxOrNull()!!
    var time = 0L

    while (l <= r) {
        val mid = (l + r) / 2
        var cnt = m.toLong()

        for (i in arr.indices) {
            cnt += mid / arr[i]
        }

        if (cnt >= n) {
            time = mid
            r = mid - 1
        } else {
            l = mid + 1
        }
    }

    var cnt = m.toLong()
    for (i in 0 until m) {
        cnt += (time - 1) / arr[i]
    }

    for (i in 0 until m) {
        if (time % arr[i] == 0L) {
            cnt++
        }
        if (cnt == n) {
            println(i + 1)
            return
        }
    }
}