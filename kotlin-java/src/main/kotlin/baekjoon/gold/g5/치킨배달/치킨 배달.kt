package baekjoon.gold.g5.치킨배달

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.min

data class Node(var x: Int, var y: Int)

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

var n = 0
var m = 0

lateinit var map: Array<Array<Int>>
lateinit var visited: Array<Boolean>
var resultLen = Int.MAX_VALUE
val chicken = ArrayList<Node>()
val house = ArrayList<Node>()


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    n = nm[0].toInt()
    m = nm[1].toInt()
    map = Array(n) { Array(n) { 0 } }
    // 0 - 빈 칸, 1 - 집, 2 - 치킨집

    repeat(n) { x ->
        val st = StringTokenizer(br.readLine(), " ")
        repeat(n) { y ->
            val temp = st.nextToken().toInt()
            map[x][y] = temp
            if (temp == 1) {
                house.add(Node(x, y))
            } else if (temp == 2) {
                chicken.add(Node(x, y))
            }
        }
    }

    visited = Array(chicken.size) { false }

    dfs(0, 0)
    println(resultLen)
}

fun dfs(idx: Int, depth: Int) {
    if (depth == m) {
        var total = 0
        for (i in 0 until house.size) {
            var sum = Int.MAX_VALUE
            for (j in 0 until chicken.size) {
                if (visited[j]) {
                    val len = abs(house[i].x - chicken[j].x) + abs(house[i].y - chicken[j].y)
                    sum = min(sum, len)
                }
            }
            total += sum
        }
        resultLen = min(total, resultLen)
        return
    }

    for (i in idx until chicken.size) {
        if (!visited[i]) {
            visited[i] = true
            dfs(i + 1, depth + 1)
            visited[i] = false
        }
    }
}