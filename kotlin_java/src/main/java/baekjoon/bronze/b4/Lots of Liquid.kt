package baekjoon.bronze.b4

import java.util.*
import kotlin.math.cbrt
import kotlin.math.pow

fun main() {
    var n = readln().toInt()
    var sum = 0.0
    val st = StringTokenizer(readln())
    while (n-- > 0) {
        sum += st.nextToken().toDouble().pow(3.0)
    }
    println(cbrt(sum))
}
