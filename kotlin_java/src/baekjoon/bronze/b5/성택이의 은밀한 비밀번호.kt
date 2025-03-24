package baekjoon.bronze.b5

fun main() {
    val n = readLine()!!.toInt()

    repeat(n) {
        val line = readLine()!!
        println(if (line.length in 6..9) "yes" else "no")
    }
}