package baekjoon.bronze.b4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val vowel = arrayOf('a', 'e', 'i', 'o', 'u','A','E','I','O','U')
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val line = br.readLine()
        if (line == "#") break
        var cnt = 0
        for (i in line) {
            if (i in vowel) {
                cnt++
            }
        }
        println(cnt)
    }
}