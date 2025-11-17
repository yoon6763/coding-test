package baekjoon.bronze.b3

fun main() {
    while (true) {
        val (r0, w, c, r) = readln().split(" ").map { it.toInt() }
        if (r0 + w + c + r == 0) break
        println(if (c * w - r0 > 0) (c * w - r0 + r - 1) / r else 0)
    }
}
