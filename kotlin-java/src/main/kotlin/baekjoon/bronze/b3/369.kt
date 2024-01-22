package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var cnt = 0
    for (i in 3..n) {
        val str = i.toString()
        cnt += str.count { it == '3' || it == '6' || it == '9' }
    }
    println(cnt)
}