package baekjoon.bronze.b3

fun main() {
    var user = 1

    while (true) {
        val L = readln().toInt()
        if (L == 0) break

        val N = readln().toInt()

        println("User $user")

        repeat(N) {
            val steps = readln().toInt()
            val distance = L * steps / 100000.0
            println("%.5f".format(distance))
        }

        user++
    }
}