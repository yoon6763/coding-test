package baekjoon.bronze.b5

fun main() {
    repeat(readLine()!!.toInt()) {
        val (t1, t2, u1, u2) = readLine()!!.split(" ").map { it.toLong() }
        println(if (t1 * t2 > u1 * u2) "TelecomParisTech" else if (t1 * t2 < u1 * u2) "Eurecom" else "Tie")
    }
}