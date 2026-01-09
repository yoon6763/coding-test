package baekjoon.bronze.b3

fun main() {
    readln()
    var total = 0
    var officialAtBats = 0

    readln().split(" ").map { it.toInt() }.forEach { bat ->
        if (bat == -1) return@forEach
        total += bat
        officialAtBats++
    }

    println(total.toDouble() / officialAtBats)
}
