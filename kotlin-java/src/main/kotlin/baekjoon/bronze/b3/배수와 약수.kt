package baekjoon.bronze.b3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    while (true) {
        val line = br.readLine().split(" ").map { it.toInt() }

        if (line[0] == 0 && line[1] == 0) break

        if (line[0] < line[1] && line[1] % line[0] == 0) {
            sb.append("factor\n")
        } else if (line[0] > line[1] && line[0] % line[1] == 0) {
            sb.append("multiple\n")
        } else {
            sb.append("neither\n")
        }
    }
    print(sb)
}