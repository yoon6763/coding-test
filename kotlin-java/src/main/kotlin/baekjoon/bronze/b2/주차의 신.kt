package baekjoon.bronze.b2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        val m = readLine().toInt()
        val arr = readLine().split(" ").map { it.toInt() }.sorted()
        println((arr[arr.size - 1] - arr[0]) * 2)
    }
}
