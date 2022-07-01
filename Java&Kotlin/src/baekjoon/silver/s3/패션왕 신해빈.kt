package baekjoon.silver.s3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    repeat(T) {
        val n = br.readLine().toInt()

        val hashSet = HashMap<String, Int>()

        repeat(n) {
            val line = br.readLine().split(" ") // 의상 이름, 의상 종류
            hashSet[line[1]] = hashSet.getOrDefault(line[1], 0) + 1
        }

        var result = 1

        hashSet.keys.forEach {
            result *= (1 + hashSet.getOrDefault(it, 0))
        }
        println(result - 1)
    }
}