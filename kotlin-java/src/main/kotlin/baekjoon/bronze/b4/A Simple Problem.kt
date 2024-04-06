package baekjoon.bronze.b4

import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        println(readLine().toDouble().pow(2).toLong())
    }
}