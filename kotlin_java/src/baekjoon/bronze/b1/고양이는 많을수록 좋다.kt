package baekjoon.bronze.b1

fun main() {
    var n = readln().toLong()
    var cnt = 0
    while (n > 3) {
        cnt++
        n = n / 2 + (if (n % 2 == 1L) 1 else 0)
    }
    println(cnt + n)
}