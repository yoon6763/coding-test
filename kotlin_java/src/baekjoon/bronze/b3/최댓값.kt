package baekjoon.bronze.b3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var x = 0
    var y = 0
    var max = 0

    repeat(9) { i ->
        val st = StringTokenizer(br.readLine())
        repeat(9) { j ->
            val n = st.nextToken().toInt()
            if (max < n) {
                max = n
                x = i
                y = j
            }
        }
    }
    println(max)
    println("${x + 1} ${y + 1}")
}