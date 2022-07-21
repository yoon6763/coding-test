package baekjoon.silver.s2

fun main() {
    val ab = readLine()!!.split(" ")
    val a = ab[0].toInt()
    var b = ab[1].toInt()

    var cnt = 0

    while (a != b) {
        if (a > b) {
            println(-1)
            return
        }

        if (b % 10 == 1) {
            b /= 10
        } else if (b % 2 == 0) {
            b /= 2
        } else {
            println(-1)
            return
        }
        cnt++
    }

    println(cnt + 1)
}