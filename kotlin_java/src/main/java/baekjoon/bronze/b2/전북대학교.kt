package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    if (n % 2 == 0) {
        println("I LOVE CBNU")
        return
    }

    println("*".repeat(n))

    var layer = n / 2 + 1

    repeat(layer) {
        print(" ".repeat(layer - 1) + "*")
        if (it != 0) {
            println(" ".repeat(it * 2 - 1) + "*")
        } else {
            println()
        }
        layer--
    }
}