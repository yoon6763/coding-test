package baekjoon.star

fun main() {
    val layer = readLine()!!.toInt()
    repeat(layer) {it ->
        repeat(layer - it) { it2 ->
            print("*")
        }
        println()
    }
}