package baekjoon.bronze.b3

import java.util.*

fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) break
        val st = StringTokenizer(readln())
        var ans = 0
        repeat(n) {
            val x = st.nextToken().toInt()
            if (ans + x < 301) ans += x
        }
        println(ans)
    }
}
