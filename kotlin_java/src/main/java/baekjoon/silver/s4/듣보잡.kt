package baekjoon.silver.s4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val map = HashMap<String, Int>()
    val list = ArrayList<String>()

    repeat(n + m) {
        val name = br.readLine()
        if (it < n)
            map[name] = 1
        else {
            map[name] = map.getOrDefault(name, 0) + 1
            if (map[name] == 2) list.add(name)
        }
    }

    println(list.size)
    list.sorted().forEach { println(it) }
}