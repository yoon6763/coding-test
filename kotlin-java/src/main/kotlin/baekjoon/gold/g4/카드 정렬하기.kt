package baekjoon.gold.g4

import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val cards = PriorityQueue<Int>()

    repeat(n) {
        cards.add(br.readLine().toInt())
    }

    var total = 0

    while (cards.isNotEmpty()) {
        val a = cards.poll()
        if (cards.isNotEmpty()) {
            val sum = a + cards.poll()
            total += sum
            cards.add(sum)
        }
    }

    println(total)
}