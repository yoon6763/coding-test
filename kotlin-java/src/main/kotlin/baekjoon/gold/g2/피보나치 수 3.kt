package baekjoon.gold.g2

fun main() = with(System.`in`.bufferedReader()) {
    val pisanoPeriod = 1500000
    val n = readLine().toLong() % pisanoPeriod

    val fibo = LongArray(pisanoPeriod + 1)
    fibo[1] = 1

    for (i in 2..pisanoPeriod) {
        fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000
    }

    println(fibo[n.toInt()])
}