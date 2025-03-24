package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    for (i in 2..100000 step 2) {
        if (i * (i / 2) == n) {
            println(i * 4)
        }
    }
}