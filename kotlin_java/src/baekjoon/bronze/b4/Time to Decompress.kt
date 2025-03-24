package baekjoon.bronze.b4

fun main() {
    repeat(readLine()!!.toInt()) {
        val nx = readln().split(" ")
        val n = nx[0].toInt()
        val x = nx[1]
        println(x.repeat(n))
    }
}

