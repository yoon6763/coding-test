package baekjoon.silver.s3

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    var st = StringTokenizer(readLine())
    val distance = Array(n) { if (it == 0) 0 else st.nextToken().toLong() }

    st = StringTokenizer(readLine())
    val fuel = Array(n) { st.nextToken().toLong() }

    var now = 0
    var money = 0L

    while (now < n - 1) {
        var next = now + 1

        while (next < n) {
            if (fuel[now] > fuel[next]) break
            next++
        }
        if (next == n) next--

        var needFuel = 0L

        for (i in now + 1..next) {
            needFuel += distance[i]
        }

        money += needFuel * fuel[now]
        now = next
    }

    println(money)
}