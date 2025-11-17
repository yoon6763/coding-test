package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    var cnt = 0
    for (i in 3..n step 3) {
        for (j in 3..n step 3) {
            for (k in 3..n step 3) {
                if (i + j + k == n) {
                    cnt++
                }
            }
        }
    }

    println(cnt)
}