package baekjoon.gold.g2.`로고`

import java.util.*

data class Rectangle(val x1: Int, val y1: Int, val x2: Int, val y2: Int)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val rectangles = Array<Rectangle?>(n + 1) { null }
    rectangles[0] = Rectangle(0, 0, 0, 0)

    for (i in 1..n) {
        val st = StringTokenizer(readLine())
        val (x1, y1, x2, y2) = List(4) { st.nextToken().toInt() }
        rectangles[i] = Rectangle(x1, y1, x2, y2)
    }

    parent = IntArray(n + 1) { it }

    for (i in 0..<n) {
        for (j in i + 1..n) {
            if (isOverlap(rectangles[i]!!, rectangles[j]!!)) {
                union(i, j)
            }
        }
    }

    val set = HashSet(parent.map { find(it) })
    println(set.size - 1)
}

fun isOverlap(r1: Rectangle, r2: Rectangle): Boolean {
    if (r1.x1 > r2.x2) return false
    if (r1.x2 < r2.x1) return false
    if (r1.y1 > r2.y2) return false
    if (r1.y2 < r2.y1) return false
    if (r1.x1 < r2.x1 && r1.y1 < r2.y1 && r1.x2 > r2.x2 && r1.y2 > r2.y2) return false
    if (r1.x1 > r2.x1 && r1.y1 > r2.y1 && r1.x2 < r2.x2 && r1.y2 < r2.y2) return false
    return true
}

fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int) {
    val (px, py) = find(x) to find(y)
    if (px < py) parent[py] = px
    else parent[px] = py
}