package baekjoon.bronze.b3

import java.util.*

fun main() {
    var k = readln().toInt()
    val n = readln().toInt()
    var time = 0

    for (i in 0..<n) {
        val st = StringTokenizer(readln())
        val t = st.nextToken().toInt()
        val z = st.nextToken()

        time += t

        if (time > 210) break
        if (z == "T") k++
        if (k == 9) k = 1
    }
    println(k)
}
