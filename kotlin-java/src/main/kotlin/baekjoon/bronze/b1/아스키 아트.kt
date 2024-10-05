package baekjoon.bronze.b1

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLines()
    val m = input.first().split(" ").map { it.toInt() }[1]

    print(input.drop(1).map { line ->
        val st = StringTokenizer(line)
        IntArray(m) { 2126 * st.nextToken().toInt() + 7152 * st.nextToken().toInt() + 722 * st.nextToken().toInt() }
    }.joinToString("\n") { row ->
        row.joinToString("") {
            when {
                it < 510000 -> "#"
                it < 1020000 -> "o"
                it < 1530000 -> "+"
                it < 2040000 -> "-"
                else -> "."
            }
        }
    })
}