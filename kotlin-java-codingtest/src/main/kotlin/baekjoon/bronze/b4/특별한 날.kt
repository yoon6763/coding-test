package baekjoon.bronze.b4

fun main() {
    val m = readln().toInt()
    val d = readln().toInt()

    if (m == 2 && d == 18) println("Special")
    else if (m == 2) {
        if (d > 18) println("After")
        else println("Before")
    } else {
        if (m > 2) {
            println("After")
        } else {
            println("Before")
        }
    }
}