package baekjoon.bronze.b4

import java.util.*

fun main() {
    var i = 1
    while (true) {
        val st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        if (n == 0) break

        val arr = IntArray(n) { st.nextToken().toInt() }
        val ans: Double = if (n % 2 == 0) {
            (arr[(n / 2) - 1] + arr[n / 2]) / 2.0
        } else {
            arr[(n - 1) / 2].toDouble()
        }

        println("Case $i: ${"%.1f".format(ans)}")
        i++
    }
}
