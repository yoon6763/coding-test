package programmers.lv0.특이한정렬

import kotlin.math.abs

data class Node(val value: Int, val distance: Int)

fun solution(numlist: IntArray, n: Int): IntArray {

    val nodes = mutableListOf<Node>()
    for (i in numlist.indices) {
        nodes.add(Node(numlist[i], abs(numlist[i] - n)))
    }

    nodes.sortWith(compareBy({ it.distance }, { -it.value }))

    return nodes.map { it.value }.toIntArray()
}