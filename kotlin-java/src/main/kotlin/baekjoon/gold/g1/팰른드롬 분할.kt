package baekjoon.gold.g1

fun main() {
    val input = readln()
    val n = input.length
    val isPalindrome = Array(n + 1) { BooleanArray(n + 1) }
    val dp = IntArray(n + 1)

    for (i in 1..n) {
        isPalindrome[i][i] = true
    }

    for (i in 1 until n) {
        isPalindrome[i][i + 1] = input[i - 1] == input[i]
    }

    for (j in 2 until n) {
        for (i in 1..n - j) {
            if (input[i - 1] == input[i + j - 1] && isPalindrome[i + 1][i + j - 1]) {
                isPalindrome[i][i + j] = true
            }
        }
    }

    for (i in 1..n) {
        dp[i] = Int.MAX_VALUE
        for (j in 1..i) {
            if (isPalindrome[j][i]) {
                dp[i] = minOf(dp[i], dp[j - 1] + 1)
            }
        }
    }

    println(dp[n])
}
