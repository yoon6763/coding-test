package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val list = readln().split(" ").map { it.toInt() }
        println(
            maxOf(1, list[0] + list[4]) +
                    maxOf(1, list[1] + list[5]) * 5 +
                    maxOf(0, list[2] + list[6]) * 2 +
                    (list[3] + list[7]) * 2
        )
    }
}