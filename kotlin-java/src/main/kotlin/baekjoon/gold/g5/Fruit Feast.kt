package baekjoon.gold.g5

import java.util.LinkedList
import java.util.Queue

fun main() {
    val (t, a, b) = readln().split(" ").map { it.toInt() }

    val visited = Array(t + 1) { BooleanArray(2) }
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.offer(0 to 0)
    visited[0][0] = true

    while (q.isNotEmpty()) {
        val (cur, isDrink) = q.poll()
        if (cur + a <= t && !visited[cur + a][isDrink]) {
            visited[cur + a][isDrink] = true
            q.offer(cur + a to isDrink)
        }
        if (cur + b <= t && !visited[cur + b][isDrink]) {
            visited[cur + b][isDrink] = true
            q.offer(cur + b to isDrink)
        }
        if (isDrink == 0 && cur / 2 >= 0 && !visited[cur / 2][1]) {
            visited[cur / 2][1] = true
            q.offer(cur / 2 to 1)
        }
    }

    println(visited.mapIndexed { index, booleans -> if (booleans[0] || booleans[1]) index else -1 }.maxOrNull())
}