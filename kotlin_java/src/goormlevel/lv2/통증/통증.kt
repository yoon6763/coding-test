package goormlevel.lv2.`통증`

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()
    var cnt = 0
    cnt += n / 14
    n %= 14
    cnt += n / 7
    n %= 7
    println(n + cnt)
}