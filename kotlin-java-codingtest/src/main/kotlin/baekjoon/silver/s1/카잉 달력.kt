package baekjoon.silver.s1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    repeat(T) {
        val mnxy = br.readLine().split(" ")
        val m = mnxy[0].toInt()
        val n = mnxy[1].toInt()
        val x = mnxy[2].toInt() - 1
        val y = mnxy[3].toInt() - 1

        var cnt = x

        while (cnt <= m * n) {
            if (cnt % m == x && cnt % n == y)
                break
            cnt += m
        }
        println(if (cnt > m * n) -1 else cnt + 1)
    }
}

/*
3
10 12 3 9
10 12 7 2
13 11 5 6
 */