package baekjoon.bronze.b3

fun main() {
    val input = readln()
    val list = mutableListOf(1, 2, 3, 4)

    for (c in input) {
        when (c) {
            'A' -> list[0] = list[1].also { list[1] = list[0] }
            'B' -> list[0] = list[2].also { list[2] = list[0] }
            'C' -> list[0] = list[3].also { list[3] = list[0] }
            'D' -> list[1] = list[2].also { list[2] = list[1] }
            'E' -> list[1] = list[3].also { list[3] = list[1] }
            'F' -> list[2] = list[3].also { list[3] = list[2] }
        }
    }

    println(list.indexOf(1) + 1)
    println(list.indexOf(4) + 1)
}