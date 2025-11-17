package baekjoon.gold.g4

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val plusQueue = PriorityQueue<Int>(reverseOrder())
    val minusQueue = PriorityQueue<Int>()

    var oneCnt = 0
    var zeroCnt = 0

    repeat(readLine().toInt()) {
        val n = readLine().toInt()

        when {
            n > 1 -> plusQueue.offer(n)
            n < 0 -> minusQueue.offer(n)
            n == 0 -> zeroCnt++
            n == 1 -> oneCnt++
        }
    }

    var sum = 0

    while (plusQueue.size > 1) {
        sum += plusQueue.poll() * plusQueue.poll()
    }
    if (plusQueue.isNotEmpty()) sum += plusQueue.poll()

    while (minusQueue.size > 1) {
        sum += minusQueue.poll() * minusQueue.poll()
    }
    if (minusQueue.isNotEmpty() && zeroCnt == 0) sum += minusQueue.poll()

    println(sum + oneCnt)
}