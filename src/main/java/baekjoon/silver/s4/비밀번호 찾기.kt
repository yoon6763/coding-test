package baekjoon.silver.s4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val hashMap = HashMap<String, String>()

    repeat(n) {
        val line = br.readLine().split(" ")
        hashMap[line[0]] = line[1]
    }

    repeat(m) {
        bw.write(hashMap[br.readLine()]+"\n")
    }
    bw.flush()
}