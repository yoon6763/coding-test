package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    for (i in 1..n) {
        print("$i ")
        if (i % 6 == 0 && i != n) {
            print("Go! ")
        }
    }

    println("Go! ")
}