package baekjoon.bronze.b5

fun main() {
    val answers = listOf(
        listOf(1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 13),
        listOf(1, 3, 5, 6, 7, 8, 9, 12, 13),
        listOf(1, 3, 5, 6, 7, 8, 9, 12, 13),
        listOf(1, 2, 3, 5, 6, 7, 8, 12, 13),
        listOf(1, 3, 5, 6, 7, 8, 12, 13),
        listOf(1, 3, 5, 6, 7, 8, 12, 13),
        listOf(1, 3, 5, 6, 7, 8, 12, 13),
        listOf(1, 3, 5, 6, 7, 8, 12, 13),
        listOf(1, 3, 5, 6, 7, 8, 12, 13),
        listOf(1, 2, 3, 6, 7, 8, 12, 13)
    )

    val n = readln().toInt()
    val selectedAnswers = answers[n - 1]

    println(selectedAnswers.size)
    println(selectedAnswers.joinToString(" ") { (it + 64).toChar().toString() })
}
