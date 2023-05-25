package baekjoon.gold.g2.택배

import java.util.StringTokenizer

data class Delivery(val startCity: Int, val endCity: Int, var capacity: Int)

fun main() = with(System.`in`.bufferedReader()) {
    // 마을 수 n, 트럭 용량 c
    val (n, c) = readLine().split(" ").map { it.toInt() }
    // 박스 정보 개수 m
    val m = readLine().toInt()

    val deliveries = Array(m) {
        val st = StringTokenizer(readLine())
        Delivery(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
    }

    val weight = Array(n + 1) { 0 }
    deliveries.sortWith(compareBy({ it.endCity }, { it.startCity }))

    var total = 0

    deliveries.forEach { delivery ->
        var able = delivery.capacity
        for (i in delivery.startCity until delivery.endCity) {
            able = minOf(able, c - weight[i])
        }

        for (i in delivery.startCity until delivery.endCity) {
            weight[i] += able
        }
        total += able

    }
    println(total)
}