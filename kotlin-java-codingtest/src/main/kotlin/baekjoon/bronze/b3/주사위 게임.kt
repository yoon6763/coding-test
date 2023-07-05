package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    var max = 0
    repeat(readLine().toInt()) {
        val nums = readLine().split(" ").map { it.toInt() }

        max = if (nums[0] == nums[1] && nums[1] == nums[2]) {
            maxOf(max, 10000 + nums[0] * 1000)
        } else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            maxOf(max, 1000 + nums.maxOrNull()!! * 100)
        } else {
            maxOf(max, nums.maxOrNull()!! * 100)
        }
    }

    println(max)
}