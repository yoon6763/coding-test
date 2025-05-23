package baekjoon.bronze.b2

import kotlin.math.min

fun main() {
    val ans = mutableListOf<String>()
    val (apple, banana) = readln().split(" ").map { it.toInt() }
    for (i in 1..min(apple, banana)) if (apple % i == 0 && banana % i == 0) ans.add("$i ${apple / i} ${banana / i}")
    println(ans.joinToString("\n"))
}
