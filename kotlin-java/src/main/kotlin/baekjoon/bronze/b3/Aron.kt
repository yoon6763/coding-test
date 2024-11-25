package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = readln()

    var p = 1
    for (i in 1..<n) {
        if (arr[i] != arr[i - 1]) {
            p++
        }
    }

    println(p + 1)
}
