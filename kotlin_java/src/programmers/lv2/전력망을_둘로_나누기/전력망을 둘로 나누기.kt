package programmers.lv2.전력망을_둘로_나누기

import java.util.*
import kotlin.math.*

lateinit var connected: Array<Array<Boolean>>
lateinit var visited: Array<Boolean>
var depth = 0
var blockSize = 0

fun solution(n: Int, wires: Array<IntArray>): Int {
    var best = Int.MAX_VALUE

    connected = Array(n+1){Array(n+1){false}}

    for(wire in wires) {
        connected[wire[0]][wire[1]] = true
        connected[wire[1]][wire[0]] = true
    }

    for(wire in wires) {
        blockSize = 0
        depth = 1
        visited = Array(n + 1) { false }

        connected[wire[0]][wire[1]] = false
        connected[wire[1]][wire[0]] = false


        visited[1] = true

        dfs(n, 1)
        best = min(best, (abs((blockSize) - abs(n - blockSize))))

        connected[wire[0]][wire[1]] = true
        connected[wire[1]][wire[0]] = true
    }

    return best
}


fun dfs(n:Int, idx:Int) {

    blockSize = max(blockSize, depth)

    for(i in 1 .. n) {
        if(connected[idx][i] && !visited[i]) {
            visited[i] = true
            depth++
            dfs(n,i)
        }
    }
}