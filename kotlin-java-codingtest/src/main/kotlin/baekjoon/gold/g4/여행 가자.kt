package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

lateinit var connected: Array<Array<Boolean>>
lateinit var parent: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    connected = Array(n) { Array(n) { false } }

    parent = Array(n) { it }

    repeat(n) { x ->
        val st = StringTokenizer(br.readLine())
        repeat(n) { y ->
            connected[x][y] = st.nextToken().toInt() == 1
        }
    }

    repeat(n) { x ->
        repeat(n) { y ->
            if (connected[x][y]) {
                if (find(x) != find(y)) {
                    union(x, y)
                }
            }
        }
    }

    val st = StringTokenizer(br.readLine())
    val target = Array(m) { 0 }
    repeat(m) {
        target[it] = st.nextToken().toInt() - 1
    }

    val firstParent = find(target[0])

    for(i in 1 until  m) {
        if(firstParent != find(target[i])) {
            println("NO")
            return
        }
    }
    println("YES")

}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int) {
    val nx = find(x)
    val ny = find(y)

    if (nx != ny) {
        parent[ny] = nx
    }
}