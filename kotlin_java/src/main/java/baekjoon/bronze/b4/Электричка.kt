package baekjoon.bronze.b4

fun main() {
    val (n, a, b) = readln().split(" ").map { it.toLong() }
    val (s, t) = readln().split(" ").map { it.toLong() }

    val isCity = { x: Long -> x in (a + 1)..<b }
    val isOutside = { x: Long -> x !in (a + 1)..<b }

    println(
        when {
            isCity(s) && isCity(t) -> "City"
            isOutside(s) && isOutside(t) && ((s <= a && t <= a) || (s >= b && t >= b)) -> "Outside"
            else -> "Full"
        }
    )
}
