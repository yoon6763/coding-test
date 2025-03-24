package baekjoon.bronze.b5

fun main() {
    readln()
    var n = 0
    readln().split(" ").forEach { n += it.toInt() }
    print(if (n == 0) "Stay" else if (n > 0) "Right" else "Left")
}