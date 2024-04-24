package baekjoon.bronze.b2

fun main() {
    val target = readln()
    val key = readln().repeat(30000)
    for ((index, word) in target.withIndex()) print(if (word == ' ') ' ' else ((word - key[index] - 1).let { if (it < 0) it + 26 else it } + 'a'.code).toChar())
}