package baekjoon.bronze.b3

import kotlin.math.max
import kotlin.math.min

fun main() {
    val (num1, opt1, num2, opt2, num3) = readln().split(" ")

    fun calculate(x: Int, y: Int, o: Char): Int {
        return when (o) {
            '*' -> x * y
            '/' -> x / y
            '+' -> x + y
            '-' -> x - y
            else -> 0
        }
    }

    val ans1 = calculate(calculate(num1.toInt(), num2.toInt(), opt1[0]), num3.toInt(), opt2[0])
    val ans2 = calculate(num1.toInt(), calculate(num2.toInt(), num3.toInt(), opt2[0]), opt1[0])

    println(min(ans1, ans2))
    println(max(ans1, ans2))
}
