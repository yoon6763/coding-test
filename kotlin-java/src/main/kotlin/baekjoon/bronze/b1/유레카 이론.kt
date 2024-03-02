package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    val nums = ArrayList<Int>()
    var temp = 1

    for (i in 2..50) {
        nums.add(temp)
        temp += i
    }

    nextCase@ for (t in 0..<readLine().toInt()) {
        val n = readLine().toInt()
        for (i in nums.indices) {
            for (j in nums.indices) {
                for (k in nums.indices) {
                    if (nums[i] + nums[j] + nums[k] == n) {
                        println(1)
                        continue@nextCase
                    }
                }
            }
        }
        println(0)
    }
}