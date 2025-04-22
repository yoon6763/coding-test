package baekjoon.bronze.b1

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val words = readln().split(" ")

    var buffer = 0
    for (word in words) {
        if (buffer + word.length > k) {
            println()
            buffer = 0
        }
        if (buffer != 0) print(" ")
        print(word)
        buffer += word.length
    }
}