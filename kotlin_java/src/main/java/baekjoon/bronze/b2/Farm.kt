package baekjoon.bronze.b2

fun main() {
    val (a, b, n, w) = readln().split(" ").map { it.toInt() }
    var cnt = 0
    var goat = 0
    var sheep = 0

    for (i in 1..<n) {
        if (a * i + b * (n - i) == w) {
            if (cnt == 2) {
                println("-1")
                return
            }
            cnt++
            sheep = i
            goat = n - i
        }
    }

    println(if (cnt == 0) "-1" else "$sheep $goat")
}