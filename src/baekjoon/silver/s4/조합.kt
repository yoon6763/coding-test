package baekjoon.silver.s4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val line = br.readLine().split(" ")
    val n = line[0].toInt()
    val m = line[1].toInt()

    var result = BigInteger.ONE

    for (i in 1..m) {
        result = result.multiply(BigInteger((n - i + 1).toString())).divide(BigInteger(i.toString()))
    }
    println(result)
}