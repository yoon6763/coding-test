package baekjoon.bronze.b2

fun main() {
    val (j, n) = readln().split(" ").map { it.toInt() }
    var count = 0

    repeat(n) {
        var sum = 0

        readln().forEach {
            sum += when {
                it.isUpperCase() -> 4
                it.isLowerCase() || it.isDigit() -> 2
                it == ' ' -> 1
                else -> 0
            }
        }
        if (j >= sum) count++
    }

    println(count)
}
