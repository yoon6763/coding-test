package baekjoon.silver.s4

import java.math.BigInteger
import java.util.StringTokenizer

fun main() {
    val list = mutableListOf<BigInteger>()
    repeat(readln().toInt()) {
        val line = StringTokenizer(readln(), "abcdefghijklmnopqrstuvwxyz")
        while (line.hasMoreTokens()) {
            list.add(line.nextToken().toBigInteger())
        }
    }
    println(list.sorted().joinToString("\n"))
}