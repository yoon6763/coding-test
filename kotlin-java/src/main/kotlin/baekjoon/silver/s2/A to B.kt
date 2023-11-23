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

        // 10으로 나눴을때 나머지가 1 --> 오른쪽에 1 삽입
        if (b % 10 == 1) {
            b /= 10
        } else if (b % 2 == 0) {
            // 10으로 나눌 수 없으면 2로 나눔
            b /= 2
        } else {
            println(-1)
            return
        }
        cnt++
    }

    println(cnt + 1)
}