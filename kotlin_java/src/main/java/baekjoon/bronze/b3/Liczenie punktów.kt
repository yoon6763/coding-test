package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val line = readln()
    var cnt = 0

    for (i in 0 until n step n / 10) {
        if(line.slice(i until i + n / 10).count { it == 'T' } == n / 10) cnt++
    }
    println(cnt)
}