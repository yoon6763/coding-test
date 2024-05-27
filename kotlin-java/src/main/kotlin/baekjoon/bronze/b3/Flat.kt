package baekjoon.bronze.b3

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) {
        val st = StringTokenizer(readln())
        st.nextToken().toDouble() to st.nextToken()
    }

    println(arr.sumOf { it.first }.toInt())
    println(arr.filter { it.second == "bedroom" }.sumOf { it.first }.toInt())
    println(arr.sumOf { if (it.second == "balcony") it.first / 2 else it.first } * m)
}