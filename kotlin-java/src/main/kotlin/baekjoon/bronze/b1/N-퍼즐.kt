package baekjoon.bronze.b1

fun main() {
    val puzzle = Array(4) { readln() }
    var ans = 0

    for (i in 0..<4)
        for (j in 0..<4)
            if (puzzle[i][j] != '.')
                ans += (kotlin.math.abs((puzzle[i][j] - 'A') / 4 - i) + kotlin.math.abs((puzzle[i][j] - 'A') % 4 - j))

    println(ans)
}
