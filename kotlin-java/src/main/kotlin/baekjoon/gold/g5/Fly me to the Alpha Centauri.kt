package baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val xy = br.readLine().split(" ").map { it.toInt() }
        val diff = xy[1] - xy[0]

        val root = sqrt(diff.toDouble()).toInt()

        if(root.toDouble() == sqrt(diff.toDouble())) {
            sb.append(root * 2 - 1).append("\n")
        } else if(diff <= root * root + root) {
            sb.append(root * 2).append("\n")
        } else {
            sb.append(root * 2 + 1).append("\n")
        }
    }
    print(sb)
}

// 0 1 -> 1
// 0 2 -> 2
// 0 3 -> 3
// 0 4 -> 3
// 0 5 -> 4
// 0 6 -> 1 2 2 1 -> 4
// 0 7 -> 1 2 2 1 1 -> 5
// 0 8 -> 1 2 2 2 1 -> 5
// 0 9 -> 1 2 3 2 1 -> 5
// 0 10 -> 1 2 2 2 2 1 -> 6
// 0 11 -> 1 2 3 2 2 1 -> 6
// 0 12 -> 1 2 3 3 2 1 -> 6
// 0 13 -> 1 2 3 2 2 2 1 -> 7
// 0 14 -> 1 2 3 3 2 2 1 -> 7
// 0 15 -> 1 2 3 3 3 2 1 -> 7