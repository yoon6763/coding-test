package baekjoon.bronze.b4

fun main() {
    val n = readLine()!!.toInt()
    repeat(n) {
        println("${it+1}. ${readLine()}")
    }
}