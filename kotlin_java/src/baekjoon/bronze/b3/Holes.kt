package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    if (n == 0) {
        println(1)
        return
    }
    if (n == 1) {
        println(0)
        return
    }

    if (n % 2 != 0) print(4)
    repeat(n / 2) {
        print(8)
    }
}
