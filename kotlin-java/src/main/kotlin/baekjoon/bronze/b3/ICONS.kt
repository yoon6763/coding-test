package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var a = 0
    var b = 0

    while (true) {
        if (a * b >= n) {
            break
        }
        a++

        if (a * b >= n) {
            break
        }
        b++
    }

    println("${a} ${b}")
}