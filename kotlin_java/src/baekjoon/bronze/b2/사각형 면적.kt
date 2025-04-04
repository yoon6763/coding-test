package baekjoon.bronze.b2

fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    var (w, h) = n to n

    repeat(c) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        if (x >= w || y >= h) return@repeat

        if (h * x >= w * y) w = x
        else h = y
    }

    println(h * w)
}
