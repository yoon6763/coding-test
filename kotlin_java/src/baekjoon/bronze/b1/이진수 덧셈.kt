package baekjoon.bronze.b1

import java.math.BigInteger

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val (b1, b2) = readln().split(" ").map { BigInteger(it, 2) }
        sb.append(b1.add(b2).toString(2)).append("\n")
    }
    print(sb)
}
