package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    for (i in 0..<n) {
        sb.append(n)
    }
    if (sb.length > m) {
        println(sb.toString().substring(0, m))
        return
    }
    println(sb)
}