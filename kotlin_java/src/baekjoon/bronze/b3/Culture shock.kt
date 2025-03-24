package baekjoon.bronze.b3

import java.util.StringTokenizer

fun main() {
    readln()
    val st = StringTokenizer(readln())
    var cnt = 0
    while (st.hasMoreTokens()) {
        if(st.nextToken() in arrayOf("he", "him", "she", "her"))cnt++
    }
    println(cnt)
}
