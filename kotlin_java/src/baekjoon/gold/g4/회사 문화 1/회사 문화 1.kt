package baekjoon.gold.g4.`회사 문화 1`

lateinit var children: Array<MutableList<Int>>
lateinit var score: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    children = Array(n + 1) { mutableListOf() }
    score = IntArray(n + 1)

    "0 ${readLine()}".split(" ").map { it.toInt() }.forEachIndexed { child, parent ->
        if (parent <= 0) return@forEachIndexed
        children[parent].add(child)
    }

    repeat(m) {
        val (num, sco) = readLine().split(" ").map { it.toInt() }
        score[num] += sco
    }

    dfs(1, 0)
    println(score.drop(1).joinToString(" "))
}

fun dfs(cur: Int, pre: Int) {
    if (cur == 0) return
    score[cur] += score[pre]
    children[cur].forEach { dfs(it, cur) }
}