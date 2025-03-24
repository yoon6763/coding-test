package baekjoon.bronze.b3

import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val input = br.readLine()
    val strings = arrayOf('H','I','A','R','C')
    var min = Int.MAX_VALUE

    strings.forEach {  string ->
        min = min(min, input.count { it == string })
    }
    print(min)
}