package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.abs
import kotlin.math.sqrt

lateinit var prime: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine(), " ")

    prime = Array<Int>(100001) { 0 }
    factorization(st.nextToken().toInt(), true)

    while (st.hasMoreTokens()) {
        val oper = st.nextToken()
        val num = abs(st.nextToken().toInt())

        if (oper == "*") {
            if (num == 0) {
                println("mint chocolate")
                return
            }
            factorization(num, true)
        } else {
            factorization(num, false)
        }
    }

    for (i in 2..100000) {
        if (prime[i] < 0) {
            println("toothpaste")
            return
        }
    }
    println("mint chocolate")
}

// 소인수분해
fun factorization(n: Int, isMulti: Boolean) {
    val sign = if (isMulti) 1 else -1

    var i = 2
    var num = n

    while (i <= num) {
        while (num % i == 0) {
            prime[i] += sign
            num /= i
        }
        i++
    }
}

// 정수 -> mint chocolate
// 유리수 -> toothpaste