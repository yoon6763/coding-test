package baekjoon.bronze.b2

import java.util.*

fun main() {
    val n = readln().trim().toInt()
    val count = IntArray(2001)
    val st = StringTokenizer(readln().trim())
    repeat(n) { count[st.nextToken().toInt()]++ }
    var minIndex = -1
    var min = Int.MAX_VALUE
    for (i in 0..<count.size) {
        if (count[i] != 0 && count[i] < min) {
            min = count[i]
            minIndex = i
        }
    }
    println(minIndex)
}