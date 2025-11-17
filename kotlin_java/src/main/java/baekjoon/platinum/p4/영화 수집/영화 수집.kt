package baekjoon.platinum.p4.`영화 수집`

import java.util.*

lateinit var tree: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val movieIndexes = IntArray(n + 1)
        tree = IntArray(n + m + 1)

        for (i in 1..n) {
            movieIndexes[i] = i + m
            update(i + m, 1)
        }

        val st = StringTokenizer(readLine())
        repeat(m) {
            val movie = st.nextToken().toInt()
            sb.append("${query(movieIndexes[movie] - 1)} ")
            update(movieIndexes[movie], -1)
            movieIndexes[movie] = m - it
            update(movieIndexes[movie], 1)
        }

        sb.appendLine()
    }

    print(sb)
}

fun query(index: Int): Int {
    var sum = 0
    var mutableIndex = index
    while (mutableIndex > 0) {
        sum += tree[mutableIndex]
        mutableIndex -= (mutableIndex and -mutableIndex)
    }

    return sum
}

fun update(index: Int, value: Int) {
    var mutableIndex = index

    while (mutableIndex < tree.size) {
        tree[mutableIndex] += value
        mutableIndex += (mutableIndex and -mutableIndex)
    }
}
