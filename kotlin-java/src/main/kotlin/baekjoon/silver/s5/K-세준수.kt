package baekjoon.silver.s5

fun main() {
    val n = readln().toInt()
    val k = readln().toInt()

    val s = IntArray(n + 1) { 0 }

    for (i in 2..n) {
        if (s[i] == 0) {
            for (j in i..n step i) {
                if (j % i == 0) {
                    s[j] = maxOf(s[j], i)
                }
            }
        }
    }

    var ans = 0
    for (i in s) {
        if (i <= k) {
            ans++
        }
    }

    println(ans - 1)
}