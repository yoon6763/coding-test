package baekjoon.silver.s5

fun main() {
    val n = readln().toInt()
    var cnt = 0

    for (i in 1..<n) {
        for (j in i..<n) {
            val k = n - i - j
            if (j > k) break
            if (i + j > k) cnt++
        }
    }
    println(cnt)
}