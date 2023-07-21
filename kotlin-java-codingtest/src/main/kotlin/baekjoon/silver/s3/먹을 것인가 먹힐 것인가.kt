package baekjoon.silver.s3

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        var (aPtr, bPtr) = readLine().split(" ").map { it.toInt() - 1 }
        val aGroup = readLine().split(" ").map { it.toInt() }.sorted()
        val bGroup = readLine().split(" ").map { it.toInt() }.sorted()
        var cnt = 0

        while (aPtr >= 0 && bPtr >= 0) {
            if (aGroup[aPtr] > bGroup[bPtr]) {
                cnt += (bPtr + 1)
                aPtr--
            } else bPtr--
        }
        sb.append(cnt).append("\n")
    }
    print(sb)
}