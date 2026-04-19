package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var win = 0

    repeat(n) {
        val car = readln().toInt()
        if (car != 1) win++
    }

    println(win)
}