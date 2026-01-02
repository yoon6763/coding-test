package baekjoon.bronze.b3

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readText())
    val arr = ArrayList<Int>()
    while (st.hasMoreTokens()) {
        val n = st.nextToken().toInt()
        if (n == 0) break
        arr.add(n)
    }

    for (n in arr) {
        print("$n ")

        var sum = 0
        for (i in 1 until n) {
            if (n % i == 0) sum += i
        }

        println(
            when {
                sum < n -> "DEFICIENT"
                sum == n -> "PERFECT"
                else -> "ABUNDANT"
            }
        )
    }
}
