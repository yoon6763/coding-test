package baekjoon.gold.g4.민서의응급수술

import java.util.StringTokenizer

lateinit var parent: Array<Int>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    parent = Array(n + 1) { it }

    var cnt = 0

    repeat(m) {
        val st = StringTokenizer(readLine())
        // 사이클이 발생되었다면 이를 끊어줘야 함
        if(!union(st.nextToken().toInt(), st.nextToken().toInt())) cnt++
    }

    for (i in 2..n) {
        // 두 노드가 다른 집합에 있다면 같은 집합으로 병합(union) 후 true 반환
        if (union(1, i)) cnt++
    }

    println(cnt)
}

fun find(x: Int): Int {
    return if (parent[x] == x) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val nx = find(x)
    val ny = find(y)

    return if (nx != ny) {
        parent[ny] = nx
        true
    } else false
}