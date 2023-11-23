package baekjoon.bronze.b3

fun main() {
    val nums =  readLine()!!.split(" ").map { it.toInt() }
    println(nums.sorted()[1])
}