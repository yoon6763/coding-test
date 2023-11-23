package baekjoon.gold.g2

import java.util.*

lateinit var parent: Array<Int>
lateinit var count: Array<Int>

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val friendsCount = readLine().toInt()

        parent = Array(friendsCount * 2) { it }
        count = Array(friendsCount * 2) { 1 }

        var idx = 0
        val friendWithIndex = HashMap<String, Int>()

        repeat(friendsCount) {
            val st = StringTokenizer(readLine())
            val (f1, f2) = Array(2) { st.nextToken() }

            if (f1 !in friendWithIndex) friendWithIndex[f1] = idx++
            if (f2 !in friendWithIndex) friendWithIndex[f2] = idx++

            sb.append(union(friendWithIndex[f1]!!, friendWithIndex[f2]!!)).append("\n")
        }
    }

    print(sb)
}


fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Int {
    val nx = find(x)
    val ny = find(y)

    if (nx != ny) {
        parent[ny] = nx
        count[nx] += count[ny]
    }
    return count[nx]
}

