package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val (t, p) = readln().split(" ").map { it.toInt() }

    var count = 0
    for (i in 0..<6) {
        count += arr[i] / t
        if (arr[i] % t != 0) count++
    }
    println(count)
    println("${(n / p)} ${n % p}")
}
