package baekjoon.bronze.b5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    print(BigInteger(br.readLine()) * BigInteger(br.readLine()))
}