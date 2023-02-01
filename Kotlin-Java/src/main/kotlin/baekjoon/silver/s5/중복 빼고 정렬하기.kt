package baekjoon.silver.s5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val sb = StringBuilder()

    val hashMap = HashSet<Int>()

    repeat(n) {
        hashMap.add(st.nextToken().toInt())
    }

    hashMap.sorted().forEach {
        sb.append("$it ")
    }
    println(sb.trim())
}