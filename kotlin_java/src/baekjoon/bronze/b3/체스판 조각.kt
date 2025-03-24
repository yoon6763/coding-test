package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var sum = 0
    for (i in 1..n) sum += if (i == 1) 2 else (i / 2) + 1
    println(sum)
}
