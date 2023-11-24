package baekjoon.silver.s4._30

fun main() {
    val n = readln().toCharArray().sortedDescending().joinToString("")
    val sum = n.sumOf { it.digitToInt() } // 각 자리수의 합
    if (sum % 3 != 0 || n.last() != '0') println(-1) else println(n)
}