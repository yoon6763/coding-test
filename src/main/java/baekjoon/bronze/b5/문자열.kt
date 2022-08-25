package baekjoon.bronze.b5

fun main() {
    val n = readLine()!!.toInt()

    repeat(n) {
        val line = readLine()!!
        println("${line.first()}${line.last()}")
    }
}