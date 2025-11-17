package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()

    var max = 0
    var strick = 0
    for (i in 0..<n) {
        if (arr[i] > 0) {
            strick++
            max = maxOf(max, strick)
        } else {
            strick = 0
        }
    }

    println(max)
}