package baekjoon.bronze.b2

import kotlin.math.pow

fun main() {
    repeat(readln().toInt()) {
        println((2.0.pow(readln().toInt()) - 1).toInt())
    }
}