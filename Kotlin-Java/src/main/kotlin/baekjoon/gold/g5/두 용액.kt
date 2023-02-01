package baekjoon.gold.g5

import kotlin.math.abs

fun main() {
    val testCase = readLine()!!.toInt()
    val nums = readLine()!!.toString().trim().split(" ").map { i -> i.toInt() }.sorted()

    var min = Int.MAX_VALUE
    var left = 0
    var right = testCase - 1
    var sLeft = 0
    var sRight = testCase - 1

    while (left < right) {
        val v = nums[left] + nums[right]

        if (min > abs(v)) {
            min = abs(v)
            sLeft = left
            sRight = right

            if(v == 0) break
        }

        if (v > 0) right-- else left++
    }
    print("${nums[sLeft]} ${nums[sRight]}")
}