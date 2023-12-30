package baekjoon.bronze.b4


fun main() {
    val n = readln().toInt()

    if (n % 8 == 0) {
        println(2)
    } else if (n % 4 == 3) {
        println(3)
    } else if (n % 8 == 6) {
        println(4)
    } else {
        println(n % 8)
    }
}
