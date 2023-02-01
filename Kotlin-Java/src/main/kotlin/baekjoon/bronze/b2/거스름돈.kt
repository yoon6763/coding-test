package baekjoon.bronze.b2

fun main() {
    var n = 1000 - readln().toInt()
    val m = arrayOf(500, 100, 50, 10, 5, 1)
    var cnt = 0
    var idx = 0

    while (n > 0) {
        if (n >= m[idx]) {
            n -= m[idx]
            cnt++
        } else {
            idx++
        }
    }

    println(cnt)
}