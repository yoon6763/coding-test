package baekjoon.bronze.b3

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val coin = intArrayOf(25, 10, 5, 1)

    repeat(readLine().toInt()) {
        var n = readLine().toInt()
        val cnt = arrayOf(0, 0, 0, 0)

        for (i in coin.indices) {
            cnt[i] = n / coin[i]
            n %= coin[i]
        }

        sb.append("${cnt[0]} ${cnt[1]} ${cnt[2]} ${cnt[3]}\n")
    }

    print(sb)
}