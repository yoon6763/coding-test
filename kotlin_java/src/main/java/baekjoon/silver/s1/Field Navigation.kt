package baekjoon.silver.s1

fun main() {
//    fun Char.toNumber(): Int = when (this) {
//        'G' -> 1
//        'R' -> 10
//        'B' -> 100
//        '.' -> 0
//        else -> -1
//    }
//
//    data class Node(val x: Int, val y: Int)
//
//    val dx = arrayOf(1, -1, 0, 0)
//    val dy = arrayOf(0, 0, 1, -1)
//
//    case@ for (i in 1..readln().toInt()) {
//        val n = readln().toInt()
//        val map = Array(n) { readln().toCharArray() }
//
//        var start = Node(0, 0)
//        var end = Node(0, 0)
//
//        val tools = arrayOf(0, 1, 10, 100, 11, 101, 110, 111)
//
//        for (i in 0 until n) {
//            for (j in 0 until n) {
//                if (map[i][j] == 'S') start = Node(i, j)
//                if (map[i][j] == 'X') end = Node(i, j)
//            }
//        }
//
//        for (myTool in tools) {
//            val visited = Array(n) { IntArray(n) }
//            val q = ArrayDeque<Node>()
//            q.add(start)
//            visited[start.x][start.y] = 1
//
//            while (q.isNotEmpty()) {
//                val cur = q.removeFirst()
//
//                for (i in 0 until 4) {
//                    val nx = cur.x + dx[i]
//                    val ny = cur.y + dy[i]
//
//                    if (nx !in 0 until n || ny !in 0 until n) continue
//
//                    if (nx == end.x && ny == end.y) {
//                        println(myTool.toString().count { it == '1' })
//                        continue@case
//                    }
//
//                    val needTool = map[nx][ny].toNumber()
//                    if (needTool != 0 && myTool and needTool == 0 || visited[nx][ny] != 0) continue
//                    visited[nx][ny] = visited[cur.x][cur.y] + 1
//                    q.add(Node(nx, ny))
//                }
//            }
//        }
//    }
}