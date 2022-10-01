package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt() // 사람의 수
    val m = nm[1].toInt() // 파티의 수

    val know = br.readLine().split(" ").map { it.toInt() }
    val knowN = know[0]
    val knowPerson = Array(knowN) { 0 }

    for (i in 0 until knowN) {
        knowPerson[i] = know[i + 1]
    }




}