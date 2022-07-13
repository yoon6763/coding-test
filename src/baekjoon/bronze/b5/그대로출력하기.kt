package baekjoon.bronze.b5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    var str: String? = null
    while (br.readLine().also { str = it } != null) {
        sb.append(str).append("\n")
    }
    bw.write(sb.toString())

    br.close()
    bw.flush()
    bw.close()
}