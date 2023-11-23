package baekjoon.silver.s5

fun main() {
    val line = readLine()!!

    val cnt = Array(10) { 0 }

    for (e in line) {
        cnt[e.digitToInt()]++
    }
    val six = cnt[6] + cnt[9]
    cnt[6] = if (six % 2 == 0) six / 2 else six / 2 + 1
    cnt[9] = 0
    println(cnt.maxOrNull())
}