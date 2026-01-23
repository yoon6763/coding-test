package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()

    val rate = when {
        n >= 1_000_000 -> 0.20
        n >= 500_000 -> 0.15
        n >= 100_000 -> 0.10
        else -> 0.05
    }

    val give = (n * rate).toInt()
    val keep = n - give

    println("$give $keep")
}
