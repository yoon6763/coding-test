package baekjoon.bronze.b4

fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }
    val busTime = a + b
    val bus = busTime <= d
    val walk = c <= d
    println(
        when {
            bus && walk -> "~.~"
            !bus && !walk -> "T.T"
            bus -> "Shuttle"
            else -> "Walk"
        }
    )
}
