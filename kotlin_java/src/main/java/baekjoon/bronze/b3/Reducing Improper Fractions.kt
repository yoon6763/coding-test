package baekjoon.bronze.b3

fun main() {
    for (i in 1..readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toLong() }
        print("Case $i: ")

        if (a == 0L) {
            println("0")
            continue
        }

        if (a / b != 0L) print("${a / b} ")
        if (a % b != 0L) print("${a % b}/$b")
        println()
    }
}
