package baekjoon.bronze.b4

import java.util.*

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        val arr = IntArray(n) { st.nextToken().toInt() }

        print("Denominations: ")
        println(arr.joinToString(" "))

        var flag = true

        for (i in 1..<n) {
            if (arr[i - 1] * 2 > arr[i]) {
                flag = false
                break
            }
        }

        print(if (flag) "Good" else "Bad")
        println(" coin denominations! ")
        if (it != t - 1) println()
    }
}