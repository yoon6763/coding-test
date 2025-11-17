package baekjoon.bronze.b2

fun main() {
    readln()
    val arr = readln().split(" ").map { it.toInt() }
    val max = arr.maxOrNull()!!
    val maxIndex = arr.indexOf(max)
    println("${arr.subList(0, maxIndex).sum() ?: 0}\n${arr.subList(maxIndex + 1, arr.size).sum() ?: 0}")
}