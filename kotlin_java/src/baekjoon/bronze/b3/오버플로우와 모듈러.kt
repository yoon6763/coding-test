package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ").map { it.toLong() }
    val nums = readln().split(" ").map { it.toLong() }.toLongArray()
    var ans = 1L
    for (num in nums) {
        ans *= num % m
        ans %= m
    }
    println(ans)
}