package baekjoon.bronze.b1

var cnt = 0

fun main() {
    val n = readln().toInt()
    fibo(n)
    println("$cnt ${n - 2}")
}

fun fibo(n: Int): Int {
    return if (n == 1 || n == 2) {
        cnt++
        1
    } else fibo(n - 1) + fibo(n - 2)
}