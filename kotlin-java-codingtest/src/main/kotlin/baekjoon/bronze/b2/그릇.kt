package baekjoon.bronze.b2

fun main() {
    val line = readln()
    var sum = 10
    for (i in 1 until line.length) sum += if (line[i] == line[i - 1]) 5 else 10
    println(sum)
}