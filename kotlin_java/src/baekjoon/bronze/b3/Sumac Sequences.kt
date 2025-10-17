package baekjoon.bronze.b3

fun main() {
    var a=readln().toInt()
    var b = readln().toInt()

    var length = 2

    while (a >= b) {
        val c = a - b
        length++
        a = b
        b = c
    }

    println(length)
}
