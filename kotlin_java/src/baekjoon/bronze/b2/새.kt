package baekjoon.bronze.b2

fun main() {
    var cnt = 0
    var n = readln().toInt()
    var temp = 1
    while (n > 0) {
        if (n >= temp) {
            n -= temp
            temp++
            cnt++
        } else {
            temp = 1
        }
    }
    println(cnt)
}