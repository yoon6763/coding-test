package baekjoon.gold.g4

import java.util.*

const val MOD = 1000000007

fun main() = with(System.`in`.bufferedReader()) {
    val M = readLine().toInt()
    var st: StringTokenizer
    var N = 1L
    var S = 0L

    for (i in 0 until M) {
        st = StringTokenizer(readLine(), " ")
        val n = st.nextToken().toInt()
        val s = st.nextToken().toInt()

        S = s * N + S * n
        N *= n.toLong()
        S %= MOD.toLong()
        N %= MOD.toLong()
    }

    if (S % N != 0L) println(search(N, MOD - 2) * S % MOD)
    else println(S / N)
}

fun search(n: Long, index: Int): Long {
    if (index == 1) return n
    val temp = search(n, index / 2)
    return if (index % 2 == 1) temp * temp % MOD * n % MOD else temp * temp % MOD
}
