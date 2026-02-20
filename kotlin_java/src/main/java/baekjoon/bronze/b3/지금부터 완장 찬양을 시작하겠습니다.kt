package baekjoon.bronze.b3

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val s = readln()
    var ans = 0

    for (c in s) {
        if (c == '0') {
            ans++
            if (ans < k) continue
            println(0)
            return
        } else {
            ans = 0
        }
    }

    println(1)
}