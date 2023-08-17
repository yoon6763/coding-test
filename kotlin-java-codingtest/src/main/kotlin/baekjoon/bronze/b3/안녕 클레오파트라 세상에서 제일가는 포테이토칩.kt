package baekjoon.bronze.b3

fun main() {
    var (n, x) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }

    var idx = 0

    while (true) {
        if (arr[idx] < x) {
            println(idx + 1)
            break
        }
        idx++
        idx %= n
        x++
    }
}