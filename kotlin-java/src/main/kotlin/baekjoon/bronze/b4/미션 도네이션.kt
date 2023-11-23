package baekjoon.bronze.b4

import kotlin.math.max

fun main() {
    repeat(readLine()!!.toInt()) {
        val n = readLine()!!.toInt()
        val mission = Array(n) { Array(3) { 0L } }

        repeat(n) {
            mission[it] = readLine()!!.split(" ").map { it.toLong() }.toTypedArray()
        }
        val (k,d,a) = readLine()!!.split(" ").map { it.toLong() }
        var result = 0L

        repeat(n) {
            result += max(k * mission[it][0] - d * mission[it][1] + a * mission[it][2], 0)
        }

        println(result)
    }
}