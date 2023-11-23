package baekjoon.unrated.u0

fun main() {
    val n = readln().toInt()

    for (i in 2 until n) {
        if (n % i == 0) {
            println("No")
            return
        }
    }

    println("Yes")
}