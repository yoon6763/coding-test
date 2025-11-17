package baekjoon.silver.s5

fun main() {
    readln()
    val times = readln().split(" ").map { it.toInt() }.sorted()
    var max = 0
    for (i in times.indices) max = maxOf(max, times[i] + (times.size - i))
    println(max + 1)
}