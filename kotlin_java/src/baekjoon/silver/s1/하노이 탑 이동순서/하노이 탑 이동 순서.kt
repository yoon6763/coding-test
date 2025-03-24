package baekjoon.silver.s1.`하노이 탑 이동순서`

import java.lang.StringBuilder

val sb = StringBuilder()

fun main() {
    val n = readln().toInt()
    sb.append("${(1 shl n) - 1}\n")
    hanoi(n, 1, 2, 3)
    print(sb)
}

fun hanoi(n: Int, from: Int, mid: Int, to: Int) {
    if (n == 1) {
        sb.append("$from $to\n")
        return
    }

    hanoi(n - 1, from, to, mid)
    sb.append("$from $to\n")
    hanoi(n - 1, mid, from, to)
}