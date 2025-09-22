package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    var i = 1

    while (i * (i + 1) / 2 < n) {
        i++
    }

    val b = n - (i - 1) * i / 2
    val a = i + 1 - b
    println("$a $b")
}