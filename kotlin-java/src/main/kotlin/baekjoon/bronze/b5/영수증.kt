package baekjoon.bronze.b5

fun main() {
    val sum = readLine()!!.toLong()
    val n = readLine()!!.toInt()
    var result = 0L
    repeat(n) {
        val line = readLine()!!.split(" ")
        result += (line[0].toLong() * line[1].toLong())
    }
    println(if (sum == result) "Yes" else "No")
}