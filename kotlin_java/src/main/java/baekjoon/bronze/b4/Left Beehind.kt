package baekjoon.bronze.b4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val out = StringBuilder()
    while (true) {
        val line = br.readLine() ?: break
        if (line.isBlank()) continue
        val st = StringTokenizer(line)
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        if (x == 0 && y == 0) break
        val result = when {
            x + y == 13 -> "Never speak again."
            x > y -> "To the convention."
            x < y -> "Left beehind."
            else -> "Undecided."
        }

        out.append(result).append("\n")
    }
    print(out.toString())
}