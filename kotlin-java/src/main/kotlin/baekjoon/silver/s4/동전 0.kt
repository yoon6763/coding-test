package baekjoon.silver.s4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nk = br.readLine().split(" ")
    val n = nk[0].toInt()
    val targetPrice = nk[1].toInt()
    var nowPrice = 0

    val coin = Array(n) { 0 }

    repeat(n) {
        coin[it] = br.readLine().toInt()
    }

    var coinIdx = n - 1
    var coinCnt = 0

    while (nowPrice != targetPrice) {
        if (targetPrice < nowPrice + coin[coinIdx]) {
            coinIdx--
            continue
        }

        nowPrice += coin[coinIdx]
        coinCnt++
    }

    println(coinCnt)
}

/*
10 4200
1
5
10
50
100
500
1000
5000
10000
50000
 */