package baekjoon.bronze.b2

fun main() {
    while (true) {
        val line = readln()
        if (line == "#") break
        println(line.uppercase().filter { it.isLetter() }.toSet().size)
    }
}