package baekjoon.gold.g5.`진우의 민트초코우유`

import java.util.StringTokenizer
import kotlin.math.abs

data class Node(val x: Int, val y: Int)

var startPoint = Node(0, 0)
var ans = 0
var increaseHealth = 0
val mintChocoMilkPoints = ArrayList<Node>()
lateinit var map: Array<IntArray>
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val nmh = readLine().split(" ").map { it.toInt() }
    val n = nmh[0]
    val initialHealth = nmh[1]
    increaseHealth = nmh[2]

    map = Array(n) { IntArray(n) }

    for (i in 0..<n) {
        val st = StringTokenizer(readLine())
        for (j in 0..<n) {
            st.nextToken().toInt().let {
                when (it) {
                    1 -> startPoint = Node(i, j)
                    2 -> mintChocoMilkPoints.add(Node(i, j))
                }
                map[i][j] = it
            }
        }
    }

    visited = BooleanArray(mintChocoMilkPoints.size)
    solve(startPoint, initialHealth, 0)
    println(ans)
}

fun solve(cur: Node, health: Int, currentAteMintChocolateMilk: Int) {
    if (health - getDistance(startPoint, cur) >= 0) {
        ans = maxOf(ans, currentAteMintChocolateMilk)
    }

    for (i in 0..<mintChocoMilkPoints.size) {
        if (visited[i]) continue
        val mintChocoMilkPoint = mintChocoMilkPoints[i]
        val distance = getDistance(cur, mintChocoMilkPoint)
        if (health - distance < 0) continue

        visited[i] = true
        solve(
            mintChocoMilkPoint, health - distance + increaseHealth, currentAteMintChocolateMilk + 1
        )
        visited[i] = false
    }
}

fun getDistance(node1: Node, node2: Node) = abs(node1.x - node2.x) + abs(node1.y - node2.y)