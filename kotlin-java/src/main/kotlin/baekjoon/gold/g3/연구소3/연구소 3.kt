package baekjoon.gold.g3.연구소3

import java.util.*
import kotlin.collections.ArrayList

data class Virus(val x: Int, val y: Int)

lateinit var map: Array<Array<Int>>
lateinit var virusPoints: ArrayList<Virus>
lateinit var selectedVirus: Array<Virus?>
val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)
var minTime = Int.MAX_VALUE
var originEmptyCnt = 0
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    virusPoints = ArrayList<Virus>()
    selectedVirus = Array<Virus?>(m) { null }


    map = Array(n) { x ->
        val st = StringTokenizer(readLine())
        Array(n) { y ->
            val num = st.nextToken().toInt()
            if (num == 2) {
                virusPoints.add(Virus(x, y))
            } else {
                if (num == 0) originEmptyCnt++
            }
            num
        }
    }

    if (originEmptyCnt == 0) {
        println(0)
        return
    }

    backTracking(0, 0)
    println(if (minTime == Int.MAX_VALUE) -1 else minTime)
}


fun backTracking(idx: Int, cnt: Int) {
    if (cnt == m) {
        // bfs 로 바이러스 퍼트리기
        spreadVirus()
        return
    }

    for (i in idx until virusPoints.size) {
        selectedVirus[cnt] = virusPoints[i]
        backTracking(i + 1, cnt + 1)
    }
}


fun spreadVirus() {
    var emptyCnt = originEmptyCnt

    val visited = Array(n) { BooleanArray(n) { false } }
    val q = LinkedList<Virus>() as Queue<Virus>

    selectedVirus.forEach {
        q.add(it!!)
        visited[it.x][it.y] = true
    }

    var time = 0

    while (q.isNotEmpty()) {

        repeat(q.size) {
            val target = q.poll()

            for (i in 0 until 4) {
                val nx = target.x + dx[i]
                val ny = target.y + dy[i]

                if (nx !in 0 until n || ny !in 0 until n || visited[nx][ny] || map[nx][ny] == 1) continue

                if (map[nx][ny] == 0) emptyCnt--
                visited[nx][ny] = true
                q.add(Virus(nx, ny))
            }
        }

        time++

        if (emptyCnt <= 0) {
            minTime = minOf(minTime, time)
            return
        }
    }
}