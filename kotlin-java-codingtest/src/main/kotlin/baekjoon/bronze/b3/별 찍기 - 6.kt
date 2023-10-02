package baekjoon.bronze.b3

fun main() {
    val layer = readLine()!!.toInt()

    for(i in layer - 1 downTo 0) {
        repeat(layer - 1 - i) {
            print(" ")
        }
        repeat(i * 2 + 1) {
            print("*")
        }
        println()
    }
}