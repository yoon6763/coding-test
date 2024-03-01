package baekjoon.gold.g3.`할로윈의 양아치`

import java.util.StringTokenizer

data class Group(var number: Int, var candy: Int)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map(String::toInt)
    val st = StringTokenizer("0 ${readLine()}")
    val candy = Array(st.countTokens()) { st.nextToken().toInt() }

    parent = IntArray(n + 1) { it }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (v1, v2) = listOf(st.nextToken().toInt(), st.nextToken().toInt())
        union(v1, v2)
    }

    val groups = ArrayList<Group>()
    val groupNumber = IntArray(n + 1) { 1 }
    val groupCandy = IntArray(n + 1) { candy[it] }

    for (i in 1..n) {
        if (parent[i] == i) continue
        val root = find(i)
        groupNumber[root] += groupNumber[i]
        groupCandy[root] += groupCandy[i]
    }

    groups.add(Group(0, 0))

    for (i in 1..n) {
        if (parent[i] != i) continue
        groups.add(Group(groupNumber[i], groupCandy[i]))
    }

    val groupSize = groups.size - 1
    val dp = Array(groupSize + 1) { IntArray(k) }

    for (i in 1..groupSize) {
        for (j in 1 until k) {
            if (j - groups[i].number >= 0) {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - groups[i].number] + groups[i].candy)
            } else {
                dp[i][j] = dp[i - 1][j]
            }
        }
    }

    println(dp[groupSize][k - 1])
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int) {
    val (px, py) = find(x) to find(y)
    if (px != py) parent[px] = py
}