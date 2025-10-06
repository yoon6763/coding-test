package baekjoon.bronze.b1

fun main() {
    val r = readln().toInt()
    val sangeun = readln().trim()
    val n = readln().toInt()

    val isWinAble = mapOf(
        'R' to 'S',
        'S' to 'P',
        'P' to 'R'
    )

    var score = 0
    var maxScore = 0
    val enemy = Array(n) { readln() }

    for (i in 0..<r) {
        val map = hashMapOf(
            'R' to 0,
            'S' to 0,
            'P' to 0
        )

        for (j in 0..<n) {
            if (sangeun[i] == enemy[j][i]) score += 1 else if (isWinAble[sangeun[i]] == enemy[j][i]) score += 2
        }

        for (j in 0..<n) {
            listOf('R', 'S', 'P').forEach { c ->
                if (c == enemy[j][i]) map[c] = map[c]!! + 1 else if (isWinAble[c] == enemy[j][i]) map[c] = map[c]!! + 2
            }
        }

        maxScore += map.values.max()
    }

    println("$score\n$maxScore")
}