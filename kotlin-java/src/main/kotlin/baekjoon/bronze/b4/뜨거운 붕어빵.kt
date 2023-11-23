package baekjoon.bronze.b4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nm = br.readLine()!!.split(" ")
    repeat(nm[0].toInt()) {
        println(br.readLine()!!.reversed())
    }
}