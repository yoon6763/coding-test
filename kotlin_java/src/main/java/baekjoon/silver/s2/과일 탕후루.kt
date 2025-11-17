package baekjoon.silver.s2

import java.util.*

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val arr = IntArray(n) { st.nextToken().toInt() }
    var ans = 0

    for (i in 1..8) {
        for (j in i + 1..9) {
            var start = 0

            while (start < n) {
                if (arr[start] == i || arr[start] == j) {
                    var end = start

                    while (end < n) {
                        if (arr[end] != i && arr[end] != j) break
                        end++
                    }

                    ans = maxOf(ans, end - start)
                    start = end
                }
                start++
            }
        }
    }

    println(ans)
}