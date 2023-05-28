package baekjoon.silver.s1.단지번호붙이기

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Node(val x: Int, val y: Int)

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val map = Array(n) { Array(n) { 0 } }

    repeat(n) { x ->
        val input = br.readLine()
        repeat(n) { y ->
            map[x][y] = input[y] - '0'
        }
    }
    var blockCnt = 0
    val cntPerBlock = ArrayList<Int>()

    for (x in 0 until n) {
        for (y in 0 until n) {
            if (map[x][y] == 0) continue

            val queue: Queue<Node> = LinkedList()
            queue.offer(Node(x, y))
            map[x][y] = 0
            var cntThisBlock = 1

            while (queue.isNotEmpty()) {
                val target = queue.poll()

                for (i in 0 until 4) {
                    val nx = target.x + dx[i]
                    val ny = target.y + dy[i]

                    if (nx !in 0 until n || ny !in 0 until n || map[nx][ny] == 0 )
                        continue

                    queue.offer(Node(nx, ny))
                    map[nx][ny] = 0
                    cntThisBlock++
                }
            }

            blockCnt++
            cntPerBlock.add(cntThisBlock)
        }
    }

    println(blockCnt)
    cntPerBlock.sorted().forEach { println(it) }
}

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

3
7
8
9
 */