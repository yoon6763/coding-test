package baekjoon.bronze.b2

fun main() {
    while (true) {
        val line = readln()
        if (line[0] == '#') break

        println("${line[0]} ${line.count { it.lowercaseChar() == line[0].lowercaseChar() } - 1}")
    }
}