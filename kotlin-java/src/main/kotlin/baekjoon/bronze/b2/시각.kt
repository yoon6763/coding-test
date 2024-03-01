package baekjoon.bronze.b2

fun main() {
    val (n, k) = readln().split(" ")
    var cnt = 0
    for (h in 0..n.toInt()) {
        for (m in 0..59) {
            for (s in 0..59) {
                if (k in "%02d%02d%02d".format(h, m, s)) cnt++
            }
        }
    }
    println(cnt)
}