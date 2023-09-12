package programmers.lv2.피로도

import kotlin.math.*

lateinit var visited:Array<Boolean>
var max = 0

fun solution(k: Int, dungeons: Array<IntArray>): Int {
    visited = Array(dungeons.size + 1) { false }

    backTracking(0, k, dungeons)

    return max
}

fun backTracking(depth:Int, currentK:Int, dg:Array<IntArray>) {
    if(currentK < 0) return

    max = max(max, depth)

    for(i in 0 until dg.size) {
        if(visited[i] || dg[i][0] > currentK) continue

        visited[i] = true
        backTracking(depth + 1, currentK - dg[i][1], dg)
        visited[i] = false
    }
}