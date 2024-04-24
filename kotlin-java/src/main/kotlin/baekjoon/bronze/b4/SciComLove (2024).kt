package baekjoon.bronze.b4

fun main() = "SciComLove".let { println(if (readln().toLong() % 2 == 0L) it else it.reversed()) }
