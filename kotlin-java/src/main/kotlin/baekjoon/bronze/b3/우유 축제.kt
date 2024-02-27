package baekjoon.bronze.b3

import java.util.*

fun main() {
    val n = readln().toInt()
    var milk = 0
    var answer = 0
    val st = StringTokenizer(readln())
    for (i in 0..<n) {
        val num = st.nextToken().toInt()
        if (milk == num) {
            milk = if (milk + 1 == 3) 0 else milk + 1
            answer++
        }
    }
    println(answer)
}