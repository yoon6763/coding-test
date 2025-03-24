package baekjoon.bronze.b2

fun main() {
    val (r, b) = readln().split(" ").map(String::toInt)

    for (l in 1..10000) {
        if (b % l == 0) {
            val w = b / l

            if (l * 2 + w * 2 + 4 == r) {
                println("${w + 2} ${l + 2}")
                break
            }
        }
    }
}
