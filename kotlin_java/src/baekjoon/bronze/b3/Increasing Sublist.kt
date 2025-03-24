package baekjoon.bronze.b3

fun main() {
    val n = readln().trim().toInt()
    val arr = readln().trim().split(" ").map { it.toInt() }

    var length = 1
    var maxLength = 1

    for (i in 1..<n) {
        if (arr[i - 1] < arr[i]) {
            length++
            maxLength = maxOf(maxLength, length)
        } else {
            length = 1
        }
    }

    println(maxLength)
}