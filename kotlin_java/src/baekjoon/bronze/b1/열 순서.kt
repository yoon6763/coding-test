package baekjoon.bronze.b1

fun main() {
    var n = 0L
    val str = readln()

    for (i in str.indices) {
        n *= 26
        n += (str[i] - 'A' + 1)
    }

    println(n)
}
