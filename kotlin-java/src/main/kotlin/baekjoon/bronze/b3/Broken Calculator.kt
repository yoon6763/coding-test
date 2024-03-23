package baekjoon.bronze.b3

import kotlin.math.pow

fun main() {
    var pre = 1L
    repeat(readln().toInt()) {
        val oper = readln().split(" ")
        pre = when (oper[1]) {
            "*" -> (oper[0].toLong() * oper[2].toLong()).toDouble().pow(2).toLong()
            "+" -> (oper[0].toLong() + oper[2].toLong()) - pre
            "-" -> (oper[0].toLong() - oper[2].toLong()) * pre
            "/" -> (oper[0].toLong() + if (oper[0].toLong() % 2 == 1L) 1 else 0) / 2
            else -> -1
        }
        println(pre)
    }
}