package baekjoon.bronze.b3

fun main() {
    var n = readln().toInt()
    var p = 0

    while (n % 2 == 0) {
        n /= 2
        p++
    }

    println("$n $p")
}
