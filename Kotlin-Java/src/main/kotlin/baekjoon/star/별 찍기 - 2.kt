package baekjoon.star

fun main() {
    val layer = readLine()!!.toInt()
    repeat(layer) {it ->
        repeat(layer - it - 1) { it2 ->
            print(" ")
        }
        repeat(it + 1) { it2 ->
            print("*")
        }
        println()
    }
}