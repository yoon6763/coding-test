package baekjoon.bronze.b2

import kotlin.math.pow

fun main() {
    while (true) {
        val line = readln()
        var result = 0
        val n = line.length

        if (line == "#") break

        for (i in 0..<n) {
            result = when {
                line[i] == '-' -> (result + 0 * 8.0.pow(((n - 1) - i).toDouble())).toInt()
                line[i] == '\\' -> (result + 1 * 8.0.pow(((n - 1) - i).toDouble())).toInt()
                line[i] == '(' -> (result + 2 * 8.0.pow(((n - 1) - i).toDouble())).toInt()
                line[i] == '@' -> (result + 3 * 8.0.pow(((n - 1) - i).toDouble())).toInt()
                line[i] == '?' -> (result + 4 * 8.0.pow(((n - 1) - i).toDouble())).toInt()
                line[i] == '>' -> (result + 5 * 8.0.pow(((n - 1) - i).toDouble())).toInt()
                line[i] == '&' -> (result + 6 * 8.0.pow(((n - 1) - i).toDouble())).toInt()
                line[i] == '%' -> (result + 7 * 8.0.pow(((n - 1) - i).toDouble())).toInt()
                else -> (result + -1 * 8.0.pow(((n - 1) - i).toDouble())).toInt()
            }
        }
        println(result)
    }
}