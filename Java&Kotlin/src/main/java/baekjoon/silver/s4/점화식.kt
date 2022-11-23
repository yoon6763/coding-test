package baekjoon.silver.s4

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    val t = Array(n + 1) { 0L }
    t[0] = 1

    for (i in 1..n)
        for (k in 0 until i)
            t[i] += t[k] * t[i - k - 1]

    println(t[n])
}