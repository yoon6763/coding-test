package baekjoon.gold.g2.공항

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var parent: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt() // 게이트 수
    val p = br.readLine().toInt() // 비행기 수

    parent = Array(n + 1) { it }
    var cnt = 0
    for (i in 0 until p) {
        val plane = br.readLine().toInt()

        val found = find(plane)
        if (found == 0) break
        union(found - 1, found)
        cnt++
    }
    println(cnt)
}

fun union(x: Int, y: Int) {
    val nx = find(x)
    val ny = find(y)

    if (nx != ny) {
        parent[ny] = nx
    }
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}