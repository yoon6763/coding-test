package baekjoon.gold.g3

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()


    val st = StringTokenizer(readLine())
    val arr = Array(n) { st.nextToken().toInt() }


    if (n == 1) {
        println("A")
        return@with
    }

    if (n == 2) {
        println(if (arr[0] == arr[1]) arr[0] else "A")
        return@with
    }

    val diff1 = arr[1] - arr[0]
    val diff2 = arr[2] - arr[1]


    // 규칙은 항상 (앞 수) * a + b
    val a = if (diff1 == 0) 0 else diff2 / diff1
    val b = arr[1] - arr[0] * a

    for (i in 2 until n) {
        // (앞 수) * a + b가 현재 수와 같지 않음! => 수가 여러 개!
        if (arr[i - 1] * a + b != arr[i]) {
            println("B")
            return@with
        }
    }
    println(arr[n - 1] * a + b)
}