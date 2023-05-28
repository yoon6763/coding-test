package baekjoon.silver.s2.점프_점프
import java.util.*

lateinit var visited: Array<Boolean>
lateinit var stones: Array<Int>
var cnt = -1

fun main() {
    cnt = readLine()!!.toInt()
    stones = readLine()!!.toString().trim().split(" ").map { it.toInt() }.toTypedArray()
    val start = readLine()!!.toInt()

    visited = Array<Boolean>(cnt) { false }

    print(bfs(start - 1))
}


fun bfs(x: Int): Int {
    visited[x] = true
    var result = 1

    var queue = LinkedList<Int>()
    queue.add(x)

    while (!queue.isEmpty()) {
        var now = queue.poll()

        for (i in 0..2) {

            val dis =
                if (i == 0) 1 * stones[now]
                else -1 * stones[now]

            val nowx = now + dis

            if (nowx < 0 || nowx >= cnt) {
                continue
            }

            if(!visited[nowx]) {
                visited[nowx] = true
                result++
                queue.add(nowx)
            }
        }
    }

    return result
}