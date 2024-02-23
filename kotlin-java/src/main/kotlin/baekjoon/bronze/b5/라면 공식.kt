package baekjoon.bronze.b5

fun main() {
    val N = readLine()!!.toInt()

    repeat(N) {
        val (A, B, X) = readLine()!!.split(" ").map { it.toInt() }

        println(A * (X - 1) + B)
    }
}
