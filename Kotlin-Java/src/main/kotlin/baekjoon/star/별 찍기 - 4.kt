package baekjoon.star

fun main() {
    val layer = readLine()!!.toInt()
    repeat(layer) {it ->
        repeat(it) { it2 ->
            print(" ")
        }
        repeat(layer - it) { it2 ->
            print("*")
        }
        println()
    }
}