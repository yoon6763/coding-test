package baekjoon.bronze.b3

import kotlin.math.abs

fun main() {
    val list = readln().split(" ").map { it.toInt() }.sorted()
    val sum = list.sum()
    val pairs = mutableListOf<Pair<Int, Int>>()

    for (i in 0..<4) {
        pairs.add(Pair(list[i], sum - list[i]))
    }

    for (i in 0..<4) {
        for (j in i + 1..<4) {
            pairs.add(Pair(list[i] + list[j], sum - list[i] - list[j]))
        }
    }

    pairs.sortBy { abs(it.first - it.second) }
    println(abs(pairs[0].first - pairs[0].second))
}