package baekjoon.gold.g1


import java.util.*

const val P: Long = 1000000007

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine(), " ")
    val n = st.nextToken().toLong()
    val k = st.nextToken().toLong()

    println(factorial(n) * pow(factorial(k) * factorial(n - k) % P, P - 2) % P)
}

fun factorial(n: Long): Long {
    var n = n
    var fac = 1L
    while (n > 1) {
        fac = fac * n % P
        n--
    }
    return fac
}

fun pow(base: Long, expo: Long): Long {
    if (expo == 1L) {
        return base % P
    }
    val temp = pow(base, expo / 2)
    return if (expo % 2 == 1L) {
        temp * temp % P * base % P
    } else temp * temp % P
}