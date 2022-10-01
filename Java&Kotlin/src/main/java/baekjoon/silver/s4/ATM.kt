package baekjoon.silver.s4

fun main() {
    val testCase = readLine()!!.toInt()
    val nums = readLine()!!.toString().trim().split(" ").map { i -> i.toInt() }.sorted()
    var result = 0

    for (i in nums.indices) result += nums[i] * (nums.size - i)

    print(result)
}