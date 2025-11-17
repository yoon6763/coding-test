package baekjoon.bronze.b3

fun main() {
    val br = System.`in`.bufferedReader()
    repeat(br.readLine().toInt()) {
        val line = br.readLine()
        val m1 = line[line.length / 2]
        val m2 = line[line.length / 2 - 1]

        println(if(m1 == m2) "Do-it" else "Do-it-Not")
    }
}