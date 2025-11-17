package baekjoon.bronze.b4

import java.lang.StringBuilder

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val (m, n) = readln().split(" ").map { it.toInt() }
        repeat(n) {
            repeat(m) {
                sb.append('X')
            }
            sb.append("\n")
        }
        sb.append("\n")
    }
    print(sb)
}