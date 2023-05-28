package baekjoon.bronze.b2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        try {
            val line = br.readLine()

            var upper = 0
            var lower = 0
            var space = 0
            var num = 0

            for (i in line.indices) {
                val char = line[i]

                if (char == ' ') {
                    space++
                } else if (char.isDigit()) {
                    num++
                } else if (char.isLowerCase()) {
                    lower++
                } else {
                    upper++
                }
            }
            println("$lower $upper $num $space")
        } catch (e: Exception) {
            break
        }
    }
}

/*
This is String
SPACE    1    SPACE
 S a M p L e I n P u T
 0L1A2S3T4L5I6N7E8

10 2 0 2
0 10 1 8
5 6 0 16
0 8 9 0
 */