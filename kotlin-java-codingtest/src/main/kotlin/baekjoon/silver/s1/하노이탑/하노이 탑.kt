package baekjoon.silver.s1.하노이탑

import java.lang.StringBuilder
import java.math.BigInteger

val sb = StringBuilder()

fun main() {
    val n = readln().toInt()
    val cnt = BigInteger("2").pow(n) - BigInteger("1")
    sb.append("$cnt\n")
    if (n <= 20) hanoi(n, 1, 2, 3)
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