package baekjoon.silver.s5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val card = br.readLine().split(" ").map { it.toInt() }.sorted().toTypedArray()
    val m = br.readLine().toInt()
    val target = br.readLine().split(" ").map { it.toInt() }

    target.forEach {
        val targetNum = it

        var r = n - 1
        var l = 0
        var isFind = false

        while (l <= r) {
            val center = (r + l) / 2

            if (card[center] == targetNum) {
                isFind = true
                break
            } else if (card[center] < targetNum) {
                l = center + 1
            } else {
                r = center - 1
            }
        }

        sb.append("${if (isFind) 1 else 0} ")
    }
    println(sb)
}