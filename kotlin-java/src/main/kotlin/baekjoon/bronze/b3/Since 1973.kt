package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var cnt = 0
    for (i in 0 until n) {
        cnt++
        if ("50" in i.toString()) cnt++
    }
    println(cnt)
}