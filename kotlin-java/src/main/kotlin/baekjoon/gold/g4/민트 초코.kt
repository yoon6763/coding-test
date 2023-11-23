package baekjoon.gold.g4

import java.util.StringTokenizer
import kotlin.math.abs

val primes = IntArray(100002) { it }
val appearCnt = IntArray(100002)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    for (i in 2 until primes.size) {
        if (primes[i] == i) {
            for (j in i + i until primes.size step i) {
                primes[j] = i
            }
        }
    }

    val st = StringTokenizer(readLine())

    repeat(n) {
        val oper = if (it == 0 || st.nextToken() == "*") 1 else -1
        var num = abs(st.nextToken().toInt())
        if (num == 0) {
            println("mint chocolate")
            return@with
        }

        while (num > 1) {
            val prime = primes[num]
            appearCnt[prime] += oper
            num /= prime
        }
    }

    for (i in 2..100001) {
        if (appearCnt[i] < 0) {
            println("toothpaste")
            return@with
        }
    }
    println("mint chocolate")
}