package baekjoon.bronze.b2

import java.util.*
import kotlin.math.max

fun main() {
    readln().toInt()
    val st = StringTokenizer(readln())
    var sum = 0
    var max = 0
    while (st.hasMoreTokens()) {
        val num = st.nextToken().toInt()
        sum += num
        max = max(max.toDouble(), num.toDouble()).toInt()
    }
    sum -= max
    print(sum)
}