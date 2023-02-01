package baekjoon.bronze.b5

import java.util.Calendar

fun main() {
    val calendar = Calendar.getInstance()
    println(calendar[Calendar.YEAR])
    println(calendar[Calendar.MONTH] + 1)
    println(calendar[Calendar.DAY_OF_MONTH])
}