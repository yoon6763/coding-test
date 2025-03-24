package baekjoon.bronze.b4

fun main() {
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }
    var team1 = 0
    var team2 = 0

    for (i in 0..2) {
        team1 += a[i] * (i + 1)
        team2 += b[i] * (i + 1)
    }

    println(
        when {
            team1 > team2 -> "1"
            team1 < team2 -> "2"
            else -> "0"
        }
    )
}
