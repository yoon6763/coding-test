package baekjoon.bronze.b3

fun main() {
    var cnt = 0
    var n = readln().toLong()

    while (n != 1L) {
        if (n % 2 == 0L) n /= 2
        else n++
        cnt++
    }
    println(cnt)
}