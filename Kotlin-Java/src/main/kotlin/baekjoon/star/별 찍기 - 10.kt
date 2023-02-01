package baekjoon.star

import java.lang.StringBuilder

val sb = StringBuilder()

fun main() {
    val n = readLine()!!.toInt()

    repeat(n) { x ->
        repeat(n) { y ->
            star(x, y, n)
        }
        sb.append("\n")
    }
    println(sb)
}

fun star(x: Int, y: Int, n: Int) {
    if ((x / n) % 3 == 1 && (y / n) % 3 == 1) {
        sb.append(" ")
    } else if (n / 3 == 0) {
        sb.append("*")
    } else {
        star(x, y, n / 3)
    }
}