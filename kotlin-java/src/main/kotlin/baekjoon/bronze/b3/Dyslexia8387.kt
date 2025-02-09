package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val str1 = readln()
    val str2 = readln()
    var cnt = 0
    for (i in 0 until n) {
        if (str1[i] == str2[i]) cnt++
    }
    println(cnt)
}