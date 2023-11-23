package baekjoon.bronze.b3

import java.lang.StringBuilder
import java.math.BigInteger

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        BigInteger(readln()).toString(2).reversed().forEachIndexed { index, c -> if (c == '1') sb.append(index).append(" ") }
        sb.append("\n")
    }
    print(sb)
}