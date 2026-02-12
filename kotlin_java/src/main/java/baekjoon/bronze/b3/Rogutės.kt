package baekjoon.bronze.b3

fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }

    var speed = 0

    for (i in 0 until n) {
        val a = readln().toInt()
        speed += a

        if (i != n - 1 && speed > s) {
            speed -= 1
        }
    }

    println(speed)
}