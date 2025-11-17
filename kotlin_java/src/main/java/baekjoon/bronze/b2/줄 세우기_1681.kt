package baekjoon.bronze.b2

fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    var cnt = 0
    var value = 0

    while (cnt < n) {
        value++
        if (value.toString().contains(l.toString())) continue
        cnt++
    }

    println(value)
}