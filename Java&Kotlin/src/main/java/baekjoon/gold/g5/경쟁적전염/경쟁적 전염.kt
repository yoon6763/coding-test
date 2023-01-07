package baekjoon.gold.g5.경쟁적전염

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

data class Node(val x: Int, val y: Int)
data class Virus(val type: Int, val time: Int, val node: Node)

fun main() = with(System.`in`.bufferedReader()) {
    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { (Array(n) { 0 }) }
    val startingPoint = ArrayList<Node>()


    repeat(n) { x ->
        val st = StringTokenizer(readLine())
        repeat(n) { y ->
            map[x][y] = st.nextToken().toInt()
            if (map[x][y] != 0) {
                startingPoint.add(Node(x, y))
            }
        }
    }

    val (s, targetX, targetY) = readLine().split(" ").map { it.toInt() }
    startingPoint.sortBy { map[it.x][it.y] }

    val q: Queue<Virus> = LinkedList()

    startingPoint.forEach {
        q.offer(Virus(map[it.x][it.y], 0, it))
    }

    while (q.isNotEmpty()) {
        val target = q.poll()

        if(target.time == s) break

        for (i in 0 until 4) {
            val nx = target.node.x + dx[i]
            val ny = target.node.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until n || map[nx][ny] != 0) continue

            map[nx][ny] = target.type
            q.offer(Virus(target.type, target.time + 1, Node(nx, ny)))
        }
    }

    println(map[targetX - 1][targetY - 1])
}