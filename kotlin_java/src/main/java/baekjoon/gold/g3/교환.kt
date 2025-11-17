package baekjoon.gold.g3

import java.util.*
import kotlin.math.max

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val num = n.toString()
    val size = num.length
    val visited = Array(k + 1) { Array(1000001) { false } }

    val q = LinkedList<Pair<String, Int>>() as Queue<Pair<String, Int>>
    q.offer(Pair(num, 0))
    visited[0][num.toInt()] = true

    var max = -1

    while (q.isNotEmpty()) {
        val target = q.poll()

        if (target.second == k) {
            max = max(max, target.first.toInt())
        } else {
            for (i in 0 until size - 1) {
                for (j in i + 1 until size) {
                    val copy = target.first
                    if (i == 0 && copy[j] == '0') continue

                    val swap = stringSwap(copy, i, j)
                    val swapInt = swap.toInt()

                    if (!visited[target.second + 1][swapInt]) {
                        visited[target.second + 1][swapInt] = true
                        q.offer(Pair(swap, target.second + 1))
                    }
                }
            }
        }
    }

    println(max)
}

fun stringSwap(string: String, idx1: Int, idx2: Int): String {
    val copy = string.toCharArray()
    val temp = copy[idx1]
    copy[idx1] = copy[idx2]
    copy[idx2] = temp
    return copy.joinToString("")
}