package baekjoon.bronze.b4

fun main() {
    val (a, c, e) = readln().split(" ").map { it.toDouble() }
    val student = readln().split(" ").map { it.toDouble() }

    print(
        when {
            student[0] >= a && student[1] >= c && student[2] >= e -> 'A'
            student[0] >= a / 2 && student[1] >= c && student[2] >= e -> 'B'
            student[1] >= c && student[2] >= e -> 'C'
            student[1] >= c / 2 && student[2] >= e / 2 -> 'D'
            else -> 'E'
        }
    )
}
