package baekjoon.bronze.b1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val input = readLine()

    val keywords = mutableListOf<String>()
    for (i in 0 until n * 6 step 6) {
        keywords.add(input.substring(i, i + 6))
    }

    val alphabet = listOf("000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010")

    val sb = StringBuilder()

    for (i in keywords) {
        var count = 0
        for (j in alphabet) {
            var cnt = 0
            for (k in 0 until 6) {
                if (i[k] == j[k]) {
                    cnt++
                }
            }
            if (cnt >= 5) {
                sb.append((alphabet.indexOf(j) + 65).toChar())
                break
            } else {
                count++
            }
        }
        if (count == alphabet.size) {
            println(keywords.indexOf(i) + 1)
            return
        }
    }

    println(sb)
}