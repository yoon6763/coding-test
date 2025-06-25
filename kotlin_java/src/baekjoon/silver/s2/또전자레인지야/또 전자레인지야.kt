package baekjoon.silver.s2.또전자레인지야

fun main() {
    val (min, sec) = readln().split(":").map { it.toInt() }
    val totalSec = min * 60 + sec

    val visited = Array(4201) { IntArray(2) { 0 } }

    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(0 to 0)
    visited[0][0] = 1

    val dTimes = listOf(10, 60, 600)

    while (q.isNotEmpty()) {
        val (time, isStarted) = q.removeFirst()

        if (time == totalSec && isStarted == 1) {
            println(visited[time][isStarted] - 1)
            return
        }

        dTimes.map { time + it }.forEach { nextTime ->
            if (nextTime > 3600 || visited[nextTime][isStarted] != 0) return@forEach
            visited[nextTime][isStarted] = visited[time][isStarted] + 1
            q.add(nextTime to isStarted)
        }

        val nextTime = if (isStarted == 0 && time == 0) 30 else time + if (isStarted == 0) 0 else 30

        if (visited[nextTime][1] != 0 || nextTime > 3600) continue
        visited[nextTime][1] = visited[time][isStarted] + 1
        q.add(nextTime to 1)
    }
}