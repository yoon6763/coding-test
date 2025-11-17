package baekjoon.bronze.b2

import kotlin.math.pow
fun main()=print(readln().sumOf{it.digitToInt().toDouble().pow(5)}.toInt())