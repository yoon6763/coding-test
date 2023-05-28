package baekjoon.silver.s4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val dbForString = HashMap<String, Int>()
    val dbForIndex = Array(n) { "" }

    for (i in 0 until n) {
        val input = br.readLine()
        dbForString[input] = i
        dbForIndex[i] = input

    }

    repeat(m) {
        val input = br.readLine()
        if (input[0].isDigit()) {
            // 숫자 입력
            println(dbForIndex[input.toInt() - 1])
        } else {
            // 문자열 입력
            println(dbForString[input]!! + 1)
        }
    }
}