package baekjoon.silver.s3

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val hashMap = HashMap<String, Int>()

    repeat(n) {
        val line = readLine()
        if (line.length >= m) hashMap[line] = hashMap.getOrDefault(line, 0) + 1
    }

    hashMap.toList().sortedWith(compareBy({-it.second},{-it.first.length}, {it.first})).forEach { sb.append(it.first).append("\n") }
    print(sb)
}