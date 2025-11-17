package baekjoon.bronze.b3

import java.math.BigInteger

fun main() {
    val sb = StringBuilder()
    val t = readln().toInt()
    repeat(t) {
        var line = readln()
        val n = readln().toInt()
        val arr = Array(n) { readln().toBigInteger() }
        if(arr.sumOf { it } % n.toBigInteger() != BigInteger.ZERO) {
            sb.appendLine("NO")
        } else {
            sb.appendLine("YES")
        }
    }

    print(sb)
}