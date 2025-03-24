package baekjoon.bronze.b3

fun main() {
    val layer = readLine()!!.toInt()

    repeat(layer) {it ->
        repeat(layer - it - 1) { it2 ->
            print(" ")
        }
        repeat(1 + (it) * 2) { it2 ->
            print("*")
        }
        println()
    }

    for(i in layer - 2 downTo 0) {
        repeat(layer - 1 - i) {
            print(" ")
        }
        repeat(i * 2 + 1) {
            print("*")
        }
        println()
    }
}