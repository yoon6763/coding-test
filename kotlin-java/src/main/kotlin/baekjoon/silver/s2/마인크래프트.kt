package baekjoon.silver.s2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nmb = br.readLine().split(" ")
    val n = nmb[0].toInt()
    val m = nmb[1].toInt()
    val initialInventory = nmb[2].toInt()

    val map = Array(n) { Array(m) { 0 } }

    repeat(n) { x ->
        val st = StringTokenizer(br.readLine()," ")
        for(y in 0 until m) {
            map[x][y] = st.nextToken().toInt()
        }
    }

    var minH = 257 // 최대 땅의 높이는 256
    var maxH = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            val height = map[i][j]
            maxH = max(maxH, height)
            minH = min(minH, height)
        }
    }

    // 파는데 2초, 놓는데 1초
    var minSpentTime = Int.MAX_VALUE
    var resultH = 0

    for(h in minH .. maxH) {
        var inventory = initialInventory
        var spentTime = 0

        for(x in 0 until n) {
            for(y in 0 until m) {
                if(map[x][y] < h) {
                    // 놓는 작업
                    val d = h - map[x][y]
                    spentTime += d
                    inventory -= d
                } else if(map[x][y] > h) {
                    // 파는 작업
                    val d = map[x][y] - h
                    spentTime += d * 2
                    inventory += d
                }
            }
        }

        if(inventory >= 0 && spentTime <= minSpentTime) {
            minSpentTime = spentTime
            resultH = h
        }
    }

    println("$minSpentTime $resultH")
}