package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val count = Array(100001) { 0 }
    repeat(readLine().toInt()) {
        count[readLine().replace(".", "").toInt()]++
    }

    var cnt = 0

    for (idx in count.indices) {
        while (cnt < 7 && count[idx] > 0) {
            count[idx]--
            cnt++
            println(String.format("%.3f", idx / 1000.0))
        }
    }
}