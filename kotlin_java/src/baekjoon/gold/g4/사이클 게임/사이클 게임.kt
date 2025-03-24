package baekjoon.gold.g4.`사이클 게임`

import java.util.StringTokenizer

lateinit var parent: Array<Int>

fun main() {
    val br = System.`in`.bufferedReader()

    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    parent = Array(n + 1) { it }

    for(i in 0 until m) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        if(find(a) != find(b)) {
            union(a, b)
        } else {
            println(i + 1)
            return
        }
    }
    println(0)
}

fun find(x: Int): Int {
    return if (x == parent[x]) x;
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int) {
    val nx = find(x)
    val ny = find(y)

    if(nx != ny) {
        parent[nx] = ny
    }
}