package baekjoon.bronze.b3

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val p = st.nextToken().toCharArray()
    val k = st.nextToken().toInt()
    var s = 0
    val checked = BooleanArray(k + 1)

    for (i in 2..k) {
        if (checked[i]) continue
        var j = i * 2
        while (j <= k) {
            checked[j] = true
            j += i
        }
    }

    for (i in 2..<k) {
        if (!checked[i]) {
            var r = 0
            for (c in p) r = (c.code - '0'.code + r * 10) % i
            if (r == 0) s = i
        }
        if (s != 0) break
    }

    println(if (s == 0) "GOOD" else "BAD $s")
}
