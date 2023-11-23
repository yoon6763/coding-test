package baekjoon.gold.g1

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val productsSequence = readLine().split(" ").map { it.toInt() }.toMutableList()
    val pluginProducts: MutableList<Int> = ArrayList()
    var answer = 0

    nextSequence@ while (productsSequence.isNotEmpty()) {
        val product = productsSequence.removeAt(0)

        // 이미 멀티탭에 꽂혀있는 전자기기인 경우
        if (product in pluginProducts) continue

        // 멀티탭에 자리가 있는 경우
        if (pluginProducts.size < n) {
            pluginProducts.add(product)
            continue
        }

        // 멀티탭에 자리가 없는 경우
        var idx = -1
        var maxIdx = -1
        answer++

        for (i in pluginProducts.indices) {
            // 다시 사용하지 않을 경우
            if (pluginProducts[i] !in productsSequence) {
                pluginProducts.removeAt(i)
                pluginProducts.add(product)
                continue@nextSequence
            }

            // 가장 나중에 사용할 전자기기를 찾음
            val nextIdx = productsSequence.indexOf(pluginProducts[i])
            if (nextIdx > idx) {
                idx = nextIdx
                maxIdx = i
            }
        }

        // 모든 전자기기가 다시 사용할 전자기기인 경우
        // 가장 나중에 사용할 전자기기를 뽑음
        pluginProducts.removeAt(maxIdx)
        pluginProducts.add(product)
    }
    println(answer)
}