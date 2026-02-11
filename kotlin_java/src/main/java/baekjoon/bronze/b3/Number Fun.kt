package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }

        if (a + b == c ||
            a - b == c ||
            b - a == c ||
            a * b == c ||
            (b != 0 && a % b == 0 && a / b == c) ||
            (a != 0 && b % a == 0 && b / a == c)
        ) {
            println("Possible")
        } else {
            println("Impossible")
        }
    }
}
