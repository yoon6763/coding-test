package baekjoon.platinum.p5.`선분 그룹`

import java.util.*
import kotlin.math.max
import kotlin.math.min

data class Line(var x1: Long, var y1: Long, var x2: Long, var y2: Long)

lateinit var parent: IntArray
lateinit var lines: Array<Line>

fun main() = with(System.`in`.bufferedReader()) {
    var st: StringTokenizer
    val n = readLine().toInt()
    parent = IntArray(n + 1) { -1 }
    lines = Array(n + 1) { Line(0, 0, 0, 0) }

    for (i in 1..n) {
        st = StringTokenizer(readLine())
        val (x1, y1, x2, y2) = Array(4) { st.nextToken().toLong() }
        lines[i] = Line(x1, y1, x2, y2)

        for (j in 1..<i) {
            val line1 = lines[i]
            val line2 = lines[j]

            if (checkCross(line1.x1, line1.y1, line1.x2, line1.y2, line2.x1, line2.y1, line2.x2, line2.y2)) {
                union(i, j)
            }
        }
    }
    var ans = 0
    var res = 0
    for (i in 1..n) {
        if (parent[i] < 0) {
            ans++
            res = min(res.toDouble(), parent[i].toDouble()).toInt()
        }
    }
    println(ans)
    println(-res)
}

fun find(i: Int): Int {
    if (parent[i] < 0) return i
    return find(parent[i]).also { parent[i] = it }
}

fun union(x: Int, y: Int) {
    val p1 = find(x)
    val p2 = find(y)
    if (p1 == p2) return
    parent[p1] += parent[p2]
    parent[p2] = p1
}

fun ccw(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long): Int {
    val temp = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3)
    if (temp > 0) return 1
    else if (temp < 0) return -1
    return 0
}

fun checkEqualLine(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long, x4: Long, y4: Long): Boolean {
    return min(x1.toDouble(), x2.toDouble()) <= max(x3.toDouble(), x4.toDouble()) &&
            min(x3.toDouble(), x4.toDouble()) <= max(x1.toDouble(), x2.toDouble()) &&
            min(y1.toDouble(), y2.toDouble()) <= max(y3.toDouble(), y4.toDouble()) &&
            min(y3.toDouble(), y4.toDouble()) <= max(y1.toDouble(), y2.toDouble())
}

fun checkCross(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long, x4: Long, y4: Long): Boolean {
    val abc = ccw(x1, y1, x2, y2, x3, y3)
    val abd = ccw(x1, y1, x2, y2, x4, y4)
    val cda = ccw(x3, y3, x4, y4, x1, y1)
    val cdb = ccw(x3, y3, x4, y4, x2, y2)
    if (abc * abd == 0 && cda * cdb == 0) {
        return checkEqualLine(x1, y1, x2, y2, x3, y3, x4, y4)
    } else if (abc * abd <= 0 && cda * cdb <= 0) {
        return true
    }
    return false
}