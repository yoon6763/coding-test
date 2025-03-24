package baekjoon.silver.s1.체스

import java.util.*
import kotlin.collections.ArrayList

data class Point(val x: Int, val y: Int)

var map: Array<Array<Point?>> = Array(8) { Array(8) { null } }
var sx = 0
var sy = 0
var ex = 0
var ey = 0

fun main() = with(System.`in`.bufferedReader()) {
    val n = 8
    val dx = intArrayOf(1, -1, 1, -1)
    val dy = intArrayOf(1, -1, -1, 1)
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        map = Array(8) { Array(8) { null } }
        val q = LinkedList<Point>() as Queue<Point>

        val se = readLine().split(" ")
        sx = se[0][0] - 'A'
        sy = se[1].toInt() - 1
        ex = se[2][0] - 'A'
        ey = se[3].toInt() - 1

        if (sx == ex && sy == ey) {
            sb.append("0 ${se[0]} ${se[1]}\n")
            return@repeat
        }

        q.offer(Point(sx, sy))
        map[sx][sy] = Point(sx, sy)

        while (q.isNotEmpty()) {
            val target = q.poll()

            for (i in 0 until 4) {
                for (j in 1..n) {
                    val nx = target.x + dx[i] * j
                    val ny = target.y + dy[i] * j

                    if (nx !in 0 until n || ny !in 0 until n) break
                    if (map[nx][ny] != null) continue
                    map[nx][ny] = Point(target.x, target.y)
                    q.offer(Point(nx, ny))

                    if (nx == ex && ny == ey) {
                        val path = printPath(nx, ny, ArrayList())
                        sb.append("${path.size - 1} ")
                        path.forEach {
                            sb.append("${(it.x + 'A'.toInt()).toChar()} ${it.y + 1} ")
                        }
                        sb.append("\n")
                        return@repeat
                    }
                }
            }
        }
        sb.append("Impossible\n")
    }

    print(sb)
}

fun printPath(x: Int, y: Int, path: ArrayList<Point>): ArrayList<Point> {
    if (x == sx && y == sy) {
        path.add(Point(x, y))
        return path
    }
    printPath(map[x][y]!!.x, map[x][y]!!.y, path)
    path.add(Point(x, y))
    return path
}