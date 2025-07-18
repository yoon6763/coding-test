package baekjoon.bronze.b4

fun main() {
    val s = readln()
    val str = "SciComLove"
    var cnt = 0
    for (i in str.indices) {
        if (s[i] != str[i]) cnt++
    }
    println(cnt)
}