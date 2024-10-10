package baekjoon.bronze.b4


fun main() {
    val (h1, b1) = readln().split(" ").map { it.toInt() }
    val (h2, b2) = readln().split(" ").map { it.toInt() }

    val n1 = 3 * h1 + b1
    val n2 = 3 * h2 + b2

    print(
        when {
            n1 > n2 -> "1 ${n1 - n2}"
            n2 > n1 -> "2 ${n2 - n1}"
            else -> "NO SCORE"
        }
    )
}
