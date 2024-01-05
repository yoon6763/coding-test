package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var ans = 0
    for (i in 1..n) if (n % i == 0) ans += i
    println(ans * 5 - 24)
}