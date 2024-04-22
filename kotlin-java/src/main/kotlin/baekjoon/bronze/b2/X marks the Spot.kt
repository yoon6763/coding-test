package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val (s1, s2) = readLine().split(" ")
        for (i in s1.indices) {
            if (s1[i] == 'X' || s1[i] == 'x') {
                sb.append(s2[i].uppercase())
                break
            }
        }
    }
    println(sb)
}