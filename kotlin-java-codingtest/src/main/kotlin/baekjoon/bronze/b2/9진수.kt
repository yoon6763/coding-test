package baekjoon.bronze.b2

fun main() {
    var n = readln().toInt()
    val sb = StringBuilder()
    while (n != 0) {
        sb.append(n % 9)
        n /= 9
    }
    println(sb.reverse())
}