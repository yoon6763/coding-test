package baekjoon.silver.s2.`이항 계수 2`

const val div = 10007

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    println((factorial(n) * solve((factorial(n - k) * factorial(k)) % div, div - 2)) % div)
}

fun factorial(n: Int): Int {
    if (n <= 1) return 1
    return (n * factorial(n - 1)) % div
}

fun solve(a: Int, p: Int): Int {
    var mutableA = a
    var mutableP = p
    var ret = 1
    while (mutableP > 0) {
        if (mutableP % 2 == 1) {
            ret *= mutableA
            mutableP--
            ret %= div
        }
        mutableA *= mutableA
        mutableA %= div
        mutableP = mutableP shr 1
    }
    return ret
}