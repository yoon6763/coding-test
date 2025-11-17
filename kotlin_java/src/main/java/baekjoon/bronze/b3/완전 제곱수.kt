package baekjoon.bronze.b3

fun main() {
    val MAX = 500
    var result = 0
    val n = readln().toInt()

    for (i in 1..MAX) {
        for (j in i + 1..MAX) {
            if (j * j == i * i + n) {
                result++
            }
        }
    }
    println(result)
}