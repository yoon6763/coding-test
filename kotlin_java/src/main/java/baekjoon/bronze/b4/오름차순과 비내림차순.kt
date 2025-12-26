package baekjoon.bronze.b4

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    if (n == 1) {
        println(1)
        return
    }

    val st = StringTokenizer(readln())
    var pre = st.nextToken().toLong()

    repeat(n - 1) {
        val cur = st.nextToken().toLong()
        if (cur == pre) {
            println(0)
            return
        }
        pre = cur
    }

    println(1)
}
