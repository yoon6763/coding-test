package baekjoon.gold.g4

import java.util.Stack

data class Index(var x: Int, var y: Int)

fun main() {
    val line1 = readLine()!!.toCharArray()
    val line2 = readLine()!!.toCharArray()

    val len1 = line1.size
    val len2 = line2.size

    val dp = Array(len1 + 1) { Array(len2 + 1) { 0 } }
    val preIdx = Array(len1 + 1) { Array(len2 + 1) { Index(-1, -1) } }
    for (i in 1..len1) {

        for (j in 1..len2) {
            if (line1[i - 1] == line2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
                preIdx[i][j].x = i - 1
                preIdx[i][j].y = j - 1
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j]
                    preIdx[i][j].x = preIdx[i - 1][j].x
                    preIdx[i][j].y = preIdx[i - 1][j].y
                } else {
                    dp[i][j] = dp[i][j - 1]
                    preIdx[i][j].x = preIdx[i][j - 1].x
                    preIdx[i][j].y = preIdx[i][j - 1].y
                }
            }
        }
    }
    var x = preIdx[len1][len2].x
    var y = preIdx[len1][len2].y

    val stack = Stack<Index>()

    while (x != -1 && y != -1) {
        stack.push(Index(x, y))
        val next = preIdx[x][y]
        x = next.x
        y = next.y
    }

    println(dp[len1][len2])

    while (stack.isNotEmpty()) {
        print("${line1[stack.pop().x]}")
    }
}

/*
ACAYKP
CAPCAK
 */