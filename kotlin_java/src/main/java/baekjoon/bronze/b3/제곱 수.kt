package baekjoon.bronze.b3

fun main() {

    repeat(readln().toInt()) {
        if (kotlin.math.sqrt(readln().toLong().toDouble()) % 1 == 0.0) {
            println(1)
        } else {
            println(0)
        }
    }
}
