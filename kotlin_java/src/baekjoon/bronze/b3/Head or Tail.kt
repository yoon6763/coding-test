package baekjoon.bronze.b3

import java.util.*

fun main() {
    while (true) {
        var j = 0
        var m = 0
        val n = readln().toInt()
        if (n == 0) break
        val st = StringTokenizer(readln())
        repeat(n) {
            val x = st.nextToken().toInt()
            if (x == 0) m++
            else j++
        }
        println("Mary won $m times and John won $j times")
    }
}
