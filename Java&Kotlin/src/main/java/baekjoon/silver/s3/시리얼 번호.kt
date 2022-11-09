package baekjoon.silver.s3

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val texts = Array(n) { "" }

    repeat(n) {
        texts[it] = br.readLine()
    }

    texts.sortWith(compareBy(
        { it.length },
        { it.filter { it2 -> it2.isDigit() }.sumOf { it3 -> it3.digitToInt() } },
        { it }
    ))

    texts.forEach { println(it) }
}