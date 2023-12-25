package baekjoon.bronze.b3

fun main() {
    val (d1, d2, d3) = readln().split(" ").map { it.toDouble() }

    val a = (d1 + d2 + d3) / 2 - d3
    val b = (d1 + d2 + d3) / 2 - d2
    val c = (d1 + d2 + d3) / 2 - d1

    if (a <= 0 || b <= 0 || c <= 0) {
        println(-1)
        return
    } else {
        println(1)
    }

    println("$a $b $c")
}
