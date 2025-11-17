package baekjoon.platinum.p5.블록껍질

import java.util.*

data class Point(var x: Long, var y: Long)

var n = -1
var first = Point(Long.MAX_VALUE, Long.MAX_VALUE)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    val points = Array(n) {
        val st = StringTokenizer(readLine())
        Point(st.nextToken().toLong(), st.nextToken().toLong())
    }

    for (i in points.indices) {
        if (points[i].y < first.y) {
            first = points[i]
        } else if (points[i].y == first.y) {
            if (points[i].x < first.x) {
                first = points[i]
            }
        }
    }

    points.sortWith(Comparator { o1, o2 ->
        val result = ccw(first, o1, o2)
        if (result > 0) return@Comparator -1
        else if (result < 0) return@Comparator 1
        else {
            if (dist(first, o1) > dist(first, o2)) return@Comparator 1
            else return@Comparator -1
        }
    })

    val stack = Stack<Point>()
    stack.push(first)

    for (i in 1 until points.size) {
        while (stack.size > 1 && ccw(stack[stack.size - 2], stack[stack.size - 1], points[i]) <= 0) {
            stack.pop()
        }
        stack.push(points[i])
    }

    println(stack.size)
}

fun ccw(p1: Point, p2: Point, p3: Point): Int {
    val result = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y)
    return if (result > 0) 1
    else if (result < 0) -1
    else 0
}

fun dist(p1: Point, p2: Point): Long {
    return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y)
}