package baekjoon.bronze.b3

fun main() {
    var ans = 0
    var check = true

    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        ans += if (a == 1) b else -b
        if (ans < 0) check = false
    }

    println(if (check) "See you next month" else "Adios")
}
