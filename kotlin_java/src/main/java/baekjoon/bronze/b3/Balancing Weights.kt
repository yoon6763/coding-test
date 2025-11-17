package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    readln()
    val ans = readln().split(" ").map { it.toInt() }.sumOf { it * 100 }

    println(
        when {
            ans == 0 -> "Equilibrium"
            ans > 0 -> "Right"
            else -> "Left"
        }
    )
}
