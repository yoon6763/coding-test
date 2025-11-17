package baekjoon.bronze.b1

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val (a, b) = arrayOf(st.nextToken().toInt(), st.nextToken().toInt())
        LCM(a, b, GCD(a, b))
    }
}

fun GCD(n1: Int, n2: Int): Int {
    return if (n2 == 0) {
        n1
    } else {
        GCD(n2, n1 % n2)
    }
}

fun LCM(n1: Int, n2: Int, gcd: Int) {
    println(n1 * n2 / gcd)
}