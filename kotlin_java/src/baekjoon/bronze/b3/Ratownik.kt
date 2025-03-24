package baekjoon.bronze.b3

import java.util.StringTokenizer
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())

    val (n, k, x, y) = List(4) { st.nextToken().toInt() }
    var ans = 0
    repeat(n) {
        val st = StringTokenizer(readLine())
        val (xi, yi) = List(2) { st.nextToken().toInt() }
        if (sqrt(((xi - x) * (xi - x) + (yi - y) * (yi - y)).toDouble()) > k) ans++
    }

    println(ans)
}