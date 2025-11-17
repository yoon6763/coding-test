package baekjoon.bronze.b4

import java.util.*

fun main() {
    var result = ""
    var max = 0

    for (i in 0..<7) {
        val st = StringTokenizer(readln())
        val a = st.nextToken()
        val count = st.nextToken().toInt()

        if (max < count) {
            max = count
            result = a
        }
    }

    println(result)
}