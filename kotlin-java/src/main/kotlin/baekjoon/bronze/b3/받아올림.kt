package baekjoon.bronze.b3

fun main() {
    while (true) {
        var (a, b) = readln().split(" ").map { it.toInt() }
        if (a + b == 0) break
        var cnt = 0
        var add = 0

        while (a != 0 || b != 0) {
            val aFirstNum = a % 10
            val bFirstNum = b % 10

            if (aFirstNum + bFirstNum + add >= 10) {
                cnt++
                add = 1
            } else {
                add = 0
            }

            a /= 10
            b /= 10
        }
        println(cnt)
    }
}