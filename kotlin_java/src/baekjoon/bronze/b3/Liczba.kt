package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var min = 0
    var max = 0

    for (i in 2..n) {
        if (n % i != 0) {
            min = i
            break
        }
    }

    for (i in n - 1 downTo 2) {
        if (n % i != 0) {
            max = i
            break
        }
    }

    println("$min $max")
}
