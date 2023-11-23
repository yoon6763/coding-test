package baekjoon.bronze.b2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br= BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val line = br.readLine().split(" ").map { it.toInt() }
    var cnt = 0

    repeat(line[0]) {
        val ratings = br.readLine().split(" ").map { it.toInt() }
        if(ratings.sum() >= line[1] && ratings.count { it >= line[2] } == 3) {
            cnt++
            ratings.forEach { sb.append(it).append(" ") }
        }
    }
    println(cnt)
    println(sb)
}