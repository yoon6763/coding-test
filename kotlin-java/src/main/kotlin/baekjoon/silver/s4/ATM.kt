package baekjoon.silver.s4

fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map(String::toInt).sorted()
    var result = 0

    for (i in nums.indices) result += nums[i] * (nums.size - i)

    print(result)
}