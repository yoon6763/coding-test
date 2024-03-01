package baekjoon.gold.g2.`구슬 탈출`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

data class Node(var rx: Int, var ry: Int, var bx: Int, var by: Int, var depth: Int)

val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    var startRX = 0
    var startRY = 0
    var startBX = 0
    var startBY = 0

    val visited = Array(n) { Array(m) { Array(n) { Array(m) { false } } } }

    val map = Array(n) { Array(m) { ' ' } }
    repeat(n) { x ->
        val line = br.readLine()
        repeat(m) { y ->
            map[x][y] = line[y]
            if (map[x][y] == 'R') {
                startRX = x
                startRY = y
            } else if (map[x][y] == 'B') {
                startBX = x
                startBY = y
            }
        }
    }

    val q = LinkedList<Node>() as Queue<Node>
    q.offer(Node(startRX, startRY, startBX, startBY, 1))
    visited[startRX][startRY][startBX][startBY] = true

    while (q.isNotEmpty()) {
        val target = q.poll()

        if(target.depth > 10) {
            println(0)
            return
        }

        for(i in 0 until 4) {
            var nrx = target.rx
            var nry = target.ry
            var nbx = target.bx
            var nby = target.by

            var redGoal = false
            var blueGoal = false

            while (map[nbx + dx[i]][nby + dy[i]] != '#') {
                nbx += dx[i]
                nby += dy[i]

                if(map[nbx][nby] == 'O') {
                    blueGoal = true
                    break
                }
            }

            while (map[nrx + dx[i]][nry + dy[i]] != '#') {
                nrx += dx[i]
                nry += dy[i]

                if(map[nrx][nry] == 'O') {
                    redGoal = true
                    break
                }
            }

            if(blueGoal) continue
            if(redGoal) {
                println(1)
                return
            }

            if(nrx == nbx && nry == nby) {
                when (i) {
                    0 -> {
                        if(target.rx > target.bx) nrx -= dx[i]
                        else nbx -= dx[i]
                    }
                    1 -> {
                        if(target.ry < target.by) nry -= dy[i]
                        else nby -= dy[i]
                    }
                    2 -> {
                        if(target.rx < target.bx) nrx -= dx[i]
                        else nbx -= dx[i]
                    }
                    3 -> {
                        if(target.ry > target.by) nry -= dy[i]
                        else nby -= dy[i]
                    }
                }
            }

            if(!visited[nrx][nry][nbx][nby]) {
                visited[nrx][nry][nbx][nby] = true
                q.offer(Node(nrx,nry,nbx,nby, target.depth + 1))
            }
        }
    }

    println(0)
}

/*
7 7
#######
#...RB#
#.#####
#.....#
#####.#
#O....#
#######
 */