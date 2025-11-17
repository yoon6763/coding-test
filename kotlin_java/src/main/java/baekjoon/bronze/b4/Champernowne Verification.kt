package baekjoon.bronze.b4

fun main() {
    val str = readln()
    val my = StringBuilder()
    var i = 1

    while (my.length < str.length) {
        my.append(i++)
        if (my.length == str.length) {
            println(if (my.toString() == str) i - 1 else -1)
            return
        }
    }
    println(-1)
}