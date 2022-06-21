package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    repeat(T) {
        val n = br.readLine().toInt()
        val treeMap = TreeMap<Int, Int>()

        for (i in 0 until n) {
            val input = br.readLine()!!.split(" ")

            if (input[0] == "I") {
                treeMap[input[1].toInt()] = treeMap.getOrDefault(input[1].toInt(), 0) + 1
            } else {
                if (treeMap.size == 0) continue
                // D
                val key = if (input[1] == "1") treeMap.lastKey() else treeMap.firstKey()
                val keyCnt = treeMap[key]
                if (keyCnt == 1) treeMap.remove(key)
                else treeMap[key] = keyCnt!! - 1
            }
        }

        if (treeMap.size == 0)
            println("EMPTY")
        else
            println("${treeMap.lastKey()} ${treeMap.firstKey()}")
    }
}

/*

2
7
I 16
I -5643
D -1
D 1
D 1
I 123
D -1
9
I -45
I 653
D 1
I -642
I 45
I 97
D 1
D -1
I 333

EMPTY
333 -45

 */