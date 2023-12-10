package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }

    var startIndex = 0
    var max = 0

    for (i in 1..<n) {
        if (arr[i - 1] < arr[i]) {
            max = maxOf(max, arr[i] - arr[startIndex])
        } else {
            startIndex = i
        }
    }
    println(max)
}