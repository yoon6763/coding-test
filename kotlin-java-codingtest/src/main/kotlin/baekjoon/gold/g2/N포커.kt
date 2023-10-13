package baekjoon.gold.g2

fun main() = with(System.`in`.bufferedReader()) {
    val MOD = 10007
    val arr = Array(53) { IntArray(53) }

    val n = readLine()!!.toInt()
    for (i in 0..52) {
        arr[i][0] = 1
        arr[i][i] = 1
        for (k in 1 until i) {
            arr[i][k] = (arr[i - 1][k - 1] + arr[i - 1][k]) % MOD
            arr[i][i - k] = arr[i][k]
        }
    }

    var ans = 0
    for (i in 4..n step 4) {
        if ((i / 4) % 2 == 1) ans += arr[13][i / 4] * arr[52 - i][n - i]
        else ans -= arr[13][i / 4] * arr[52 - i][n - i]
        ans %= 10007
    }

    println(if (ans < 0) ans + MOD else ans)
}