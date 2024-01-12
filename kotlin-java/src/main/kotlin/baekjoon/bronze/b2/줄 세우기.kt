package baekjoon.bronze.b2

import java.util.*

fun main() {
    val list = ArrayList<Int>()
    val N = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    for (i in 0..<N) {
        val num = arr[i]
        if (num == 0) list.add(i + 1)
        else list.add(list.size - num, i + 1)
    }

    for (i in list) print("$i ")
}
