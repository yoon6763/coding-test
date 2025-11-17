package baekjoon.gold.g5.`트리`

import java.util.*
import kotlin.collections.ArrayList

lateinit var children: Array<ArrayList<Int>>
lateinit var visited: Array<Boolean>
var leafNode = 0
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    children = Array(n + 1) { ArrayList() }

    var root = 0
    val st = StringTokenizer(readLine())

    repeat(n) { childNode ->
        val parentNode = st.nextToken().toInt()

        if (parentNode == -1) {
            root = childNode
            return@repeat
        }

        children[parentNode].add(childNode)
    }

    val removeNode = readLine().toInt()

    if (removeNode == root) {
        println(0)
        return
    }

    for (i in 0..<n) {
        if (children[i].contains(removeNode)) {
            children[i].remove(removeNode)
            break
        }
    }

    visited = Array(n + 1) { false }
    visited[root] = true

    dfs(root)

    println(leafNode)
}

fun dfs(cur: Int) {
    if (children[cur].isEmpty()) {
        leafNode++
        return
    }

    children[cur].forEach { next ->
        if (visited[next]) return@forEach
        visited[next] = true
        dfs(next)
    }
}