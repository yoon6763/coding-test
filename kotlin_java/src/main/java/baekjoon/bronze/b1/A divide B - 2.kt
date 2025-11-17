package baekjoon.bronze.b1

import java.math.BigDecimal

fun main() = with(System.`in`.bufferedReader()) {
    val nums = readLine().split(" ").map { it.toInt() }.toTypedArray()
    val sb = StringBuilder()

    sb.append(nums[0] / nums[1]).append(".")

    nums[0] = nums[0] % nums[1]

    repeat(1001) {
        nums[0] *= 10
        sb.append(nums[0] / nums[1])
        nums[0] = nums[0] % nums[1]
    }

    println(sb)
}