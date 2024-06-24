package baekjoon.silver.s3

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    nextCase@ for (i in 0..<readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val count = HashMap<Long, Int>()
        val half = n / 2 + if (n % 2 != 0) 0 else 1

        for (i in 0..<n) {
            val num = st.nextToken().toLong()
            count[num] = count.getOrDefault(num, 0) + 1
            if (count[num]!! >= half) {
                sb.appendLine(num)
                continue@nextCase
            }
        }

        sb.appendLine("SYJKGW")
    }

    print(sb)
}