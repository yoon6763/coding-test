package baekjoon.silver.s2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val line = br.readLine()

    val stMinus = StringTokenizer(line, "-")
    var result = 0
    var cnt = 0

    while (stMinus.hasMoreTokens()) {
        val stPlus = StringTokenizer(stMinus.nextToken(), "+")
        var num = 0

        while (stPlus.hasMoreTokens()) {
            num += stPlus.nextToken().toInt()
        }

        if (cnt == 0 && line[0] != '-') {
            result += num
        } else {
            result -= num
        }
        cnt++
    }
    println(result)
}