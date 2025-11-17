package baekjoon.bronze.b2

fun main() {
    val arr = readln().split(":").map { it.toInt() }

    var cnt = 0
    for (i in 0..2) {
        for (j in 0..2) {
            for (k in 0..2) {
                if (i == j || j == k || i == k) continue
                if (arr[i] in 1..12 && arr[j] < 60 && arr[k] < 60) cnt++
            }
        }
    }

    println(cnt)
}
