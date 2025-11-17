package baekjoon.platinum.p5.`뱀`

const val VERTICAL = 0
const val HORIZON = 1

const val LEFT = 0
const val RIGHT = 1

data class Line(val x1: Long, val y1: Long, val x2: Long, val y2: Long, val direction: Int) {
    constructor(x1: Long, y1: Long, x2: Long, y2: Long) : this(
        minOf(x1, x2), minOf(y1, y2), maxOf(x1, x2), maxOf(y1, y2), if (x1 == x2) VERTICAL else HORIZON
    )
}

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, -1, 0, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val length = readLine().toLong()
    val n = readLine().toInt()
    var curX = 0L
    var curY = 0L
    var curDir = 0
    var ans = 0L

    val lines = ArrayList<Line>().apply {
        add(Line(-length - 1, length + 1, length + 1, length + 1))
        add(Line(length + 1, -length - 1, length + 1, length + 1))
        add(Line(-length - 1, -length - 1, length + 1, -length - 1))
        add(Line(-length - 1, -length - 1, -length - 1, length + 1))
    }

    val move = ArrayList<String>()
    repeat(n) {
        move.add(readLine())
    }

    for (i in 0..n) {
        val (distance, dir) = if (i == n) {
            Long.MAX_VALUE to LEFT
        } else {
            val str = move[i].split(" ")
            str[0].toLong() to if (str[1] == "L") LEFT else RIGHT
        }

        var t = Long.MAX_VALUE

        lines.forEach { line ->
            when (line.direction) {
                HORIZON -> when (curDir) {
                    0 -> if (curY == line.y1 && curX < line.x1) t = minOf(t, line.x1 - curX)
                    1 -> if (line.x1 <= curX && curX <= line.x2 && line.y1 < curY) t = minOf(t, curY - line.y1)
                    2 -> if (curY == line.y1 && line.x2 < curX) t = minOf(t, curX - line.x2)
                    3 -> if (line.x1 <= curX && curX <= line.x2 && curY < line.y1) t = minOf(t, line.y1 - curY)
                }

                VERTICAL -> when (curDir) {
                    0 -> if (line.y1 <= curY && curY <= line.y2 && curX < line.x1) t = minOf(t, line.x1 - curX)
                    1 -> if (curX == line.x1 && line.y2 < curY) t = minOf(t, curY - line.y2)
                    2 -> if (line.y1 <= curY && curY <= line.y2 && line.x1 < curX) t = minOf(t, curX - line.x1)
                    3 -> if (curX == line.x1 && curY < line.y1) t = minOf(t, line.y1 - curY)
                }
            }
        }

        if (distance < t) {
            lines.add(Line(curX, curY, curX + dx[curDir] * distance, curY + dy[curDir] * distance))
            curX += dx[curDir] * distance
            curY += dy[curDir] * distance
            ans += distance
            curDir = if (dir == LEFT) (curDir + 3) % 4 else (curDir + 1) % 4
        } else {
            ans += t
            break
        }
    }

    println(ans)
}
