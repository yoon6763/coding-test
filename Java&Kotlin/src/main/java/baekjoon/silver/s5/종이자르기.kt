package baekjoon.silver.s5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val wh = br.readLine().split(" ")
    val w = wh[0].toInt()
    val h = wh[1].toInt()

    val n = br.readLine().toInt()
    val cut = Array(2) { ArrayList<Int>() }
    repeat(n) {
        val line = br.readLine().split(" ").map { it.toInt() }
        cut[line[0]].add(line[1])
    }
    cut[0].add(0)
    cut[1].add(0)
    cut[0].sort()
    cut[1].sort()
    cut[0].add(h)
    cut[1].add(w)

    val section1 = Array(cut[0].size - 1) { 0 }
    val section2 = Array(cut[1].size - 1) { 0 }

    for (i in 0 until cut[0].size - 1) section1[i] = cut[0][i + 1] - cut[0][i]
    for (i in 0 until cut[1].size - 1) section2[i] = cut[1][i + 1] - cut[1][i]

    println(section1.maxOrNull()!! * section2.maxOrNull()!!)
}