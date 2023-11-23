package baekjoon.bronze.b1

fun main() {
    val nums = readLine()!!.toString().trim().split(" ").map { i -> i.toInt() }
    print(fac(nums[0]) / (fac(nums[1]) * fac(nums[0] - nums[1])))
}

fun fac(num: Int): Int {
    var result = 1
    for (i in 1..num) result *= i
    return result
}