package baekjoon.bronze.b3

fun main() {
    var (a, b) = readln().split(" ").map { it.toInt() }

    while (true) {
        b += a
        if (b >= 5) {
            println("yt")
            break
        }

        a += b
        if (a >= 5) {
            println("yj")
            break
        }
    }
}
