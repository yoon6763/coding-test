package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    var cnt = 1
    val sb = StringBuilder()
    while (cnt <= n * m) {
        sb.append(cnt)
        if (cnt % m != 0) sb.append(" ")
        else sb.append("\n")
        cnt++
    }
    print(sb)
}