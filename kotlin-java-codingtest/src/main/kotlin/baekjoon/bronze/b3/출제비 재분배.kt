package baekjoon.bronze.b3

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val arr = Array(n + m) { 0 }
    var st = StringTokenizer(readLine())

    repeat(n) {
        arr[it] = st.nextToken().toInt()
    }

    repeat(n) { it1 ->
        st = StringTokenizer(readLine())

        repeat(n + m) { it2 ->
            val num = st.nextToken().toInt()
            arr[it1] -= num
            arr[it2] += num
        }
    }

    val sb = StringBuilder()
    repeat(n+m){
        sb.append("${arr[it]} ")
    }
    println(sb)
}