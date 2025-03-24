package baekjoon.bronze.b2

fun main() {
    val N = readln().toInt()
    var card = 1

    if (N <= 10) {
        println(1)
    } else {
        while (N >= card) {
            card = (card * 10) + 1
        }
        println((card / 10).toString().length)
    }
}
