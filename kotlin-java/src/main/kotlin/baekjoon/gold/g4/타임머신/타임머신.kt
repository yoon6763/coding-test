package baekjoon.gold.g4.타임머신

import java.io.BufferedReader
import java.io.InputStreamReader

data class BUS(var from: Int, var to: Int, var weight: Int)

val MAX_VALUE = 10000000
lateinit var distance: Array<Long>
lateinit var busList: Array<BUS?>
var n = 0
var m = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nm = br.readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    busList = Array(m) { null }
    distance = Array(n + 1) { MAX_VALUE.toLong() } // 최단 거리 테이블. 최대값으로 초기화

    // 간선 정보 입력
    repeat(m) {
        val line = br.readLine().split(" ").map { it.toInt() }
        busList[it] = BUS(line[0], line[1], line[2])
    }

    // 시간을 무한히 오래 전으로 되돌릴 수 있음 (음의 사이클 발생)
    if (bellmanFord(1)) {
        println(-1)
    } else {
        for (i in 2..n) {
            // 가는 경로가 없을 때 -1 출력
            if (distance[i] == MAX_VALUE.toLong()) {
                println(-1)
            } else {
                println(distance[i])
            }
        }
    }
}


fun bellmanFord(start: Int): Boolean {
    distance[start] = 0 // 시작 노드로 가는 비용은 0

    for (i in 1 until n) {
        for (j in 0 until m) {
            val targetBus = busList[j]!!

            // 현재 수행중인 간선을 타고 다른 노드로 가는 cost 가 더 적을 경우 테이블 갱신
            if (distance[targetBus.from] != MAX_VALUE.toLong() && distance[targetBus.to] > distance[targetBus.from] + targetBus.weight) {
                distance[targetBus.to] = distance[targetBus.from] + targetBus.weight
            }
        }
    }

    // 만약 이때 경로가 더 짧은 경로로 갱신된다면 음의 사이클이 발생한 것
    for (i in 0 until m) {
        val targetBus = busList[i]!!
        if (distance[targetBus.from] != MAX_VALUE.toLong() && distance[targetBus.to] > distance[targetBus.from] + targetBus.weight) return true
    }
    return false
}