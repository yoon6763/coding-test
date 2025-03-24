package baekjoon.gold.g4.`마법사 상어와 파이어볼`

import java.util.*
import kotlin.collections.ArrayDeque

data class Fireball(var r: Int, var c: Int, var m: Int, var s: Int, var d: Int)

var dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
var dy = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) { Array(n) { ArrayList<Fireball>() } }
    val fireballQueue = ArrayDeque<Fireball>()

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (r, c, m, s, d) = Array(5) { st.nextToken().toInt() }
        fireballQueue.add(Fireball(r, c, m, s, d))
    }

    repeat(k) {
        fireballQueue.forEach { cur ->
            cur.r = (cur.r + n + dx[cur.d] * (cur.s % n)) % n
            cur.c = (cur.c + n + dy[cur.d] * (cur.s % n)) % n
            map[cur.r][cur.c].add(cur)
        }

        for (r in 0 until n) {
            for (c in 0 until n) {
                if (map[r][c].size < 2) {
                    map[r][c].clear()
                    continue
                }

                var (sumM, sumS, oddCount, evenCount) = Array(4) { 0 }
                val size = map[r][c].size

                while (map[r][c].isNotEmpty()) {
                    val cur = map[r][c].removeFirst()
                    sumM += cur.m
                    sumS += cur.s
                    if (cur.d % 2 == 1) oddCount++ else evenCount++
                    fireballQueue.remove(cur)
                }

                sumM /= 5
                if (sumM == 0) continue
                sumS /= size

                if (oddCount == size || evenCount == size)
                    for (i in 0 until 8 step 2)
                        fireballQueue.add(Fireball(r, c, sumM, sumS, i))
                else
                    for (i in 1 until 8 step 2)
                        fireballQueue.add(Fireball(r, c, sumM, sumS, i))
            }
        }
    }

    println(fireballQueue.sumOf { it.m })
}