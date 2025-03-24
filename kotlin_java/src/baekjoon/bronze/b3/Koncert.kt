package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    var (sr, sg, sb) = arrayOf(0, 0, 0)
    repeat(10) {
        val (r, g, b) = readln().split(" ").map { it.toInt() }
        sr += r
        sg += g
        sb += b
    }

    println("${Math.round(sr / 10.0)} ${Math.round(sg / 10.0)} ${Math.round(sb / 10.0)}")
}