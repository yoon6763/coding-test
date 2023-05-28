package baekjoon.bronze.b4

import java.util.StringTokenizer

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        val st = StringTokenizer(readLine())

        val name = st.nextToken()
        if (name == "#") break

        val age = st.nextToken().toInt()
        val weight = st.nextToken().toInt()

        if( age > 17 || weight >= 80) {
            sb.append("$name Senior\n")
        } else {
            sb.append("$name Junior\n")
        }
    }
    print(sb)
}