package baekjoon.bronze.b3

fun main() {
    var cnt = 0
    var n = readln().toInt()
    while (true) {
        if (n < 10) break
        n = n.toString().toCharArray().map { it - '0' }.fold(1) { acc, i -> acc * i }
        cnt++
    }

    println(cnt)
}