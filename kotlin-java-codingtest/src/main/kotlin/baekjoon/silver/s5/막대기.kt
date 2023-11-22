package baekjoon.silver.s5

fun main() {
    var x = readln().toInt()

    var len = 64
    var cnt = 0

    while (x > 0) {
        if (len > x) len /= 2
        else {
            cnt++
            x -= len
        }
    }

    println(cnt)
}