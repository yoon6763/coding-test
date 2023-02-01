package baekjoon.silver.s5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val map = HashMap<String, Boolean>()

    repeat(n) {
        val line = br.readLine().split(" ")
        map[line[0]] = line[1] == "enter"
    }

    map.keys.sortedDescending().forEach {
        if (map[it]!!) {
            println(it)
        }
    }
}