package baekjoon.bronze.b3

fun main() {
    val layer = readLine()!!.toInt()

    for(i in layer - 2 downTo 0) {
        repeat(layer - 1 - i) {
            print("*")
        }
        repeat(i * 2 + 1) {
            print(" ")
        }
        if(i != layer) print(" ")
        repeat(layer - 1 - i) {
            print("*")
        }
        println()
    }

    repeat(layer * 2) {print("*")}
    println()

    repeat(layer - 1) {it ->
        repeat(layer - it - 1) { it2 ->
            print("*")
        }
        repeat(1 + (it) * 2) { it2 ->
            print(" ")
        }
        print(" ")
        repeat(layer - it - 1) { it2 ->
            print("*")
        }
        println()
    }
}