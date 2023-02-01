package baekjoon.silver.s5

fun main() {
    val t = readLine()!!.toLong()
    val (a, b, c, d) = readLine()!!.split(" ").map { it.toLong() }

    (a * t + b).let {
        println(if (it == c * t + d) "Yes $it" else "No")
    }
}