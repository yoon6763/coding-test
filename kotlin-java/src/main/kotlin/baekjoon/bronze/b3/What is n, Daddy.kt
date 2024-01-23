package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var cnt = 0

    for (i in 0..5) {
        for (j in i..5) {
            if (i + j == n) {
                cnt++
            }
        }
    }

    println(cnt)
}
