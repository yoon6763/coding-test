package baekjoon.silver.s4

fun main() = repeat(readln().toInt()) {
    val n = readln().toInt()
    val arr = IntArray(n + 1) { if (it == 0) 0 else readln().toInt() }

    var k = 0
    var c = 1
    while (k < n - 1 && c != n) {
        c = arr[c]
        k++
    }

    println(if (c == n) k else 0)
}
