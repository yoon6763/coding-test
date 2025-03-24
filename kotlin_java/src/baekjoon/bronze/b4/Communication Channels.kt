package baekjoon.bronze.b4

fun main() {
    repeat(readln().toInt()) {
        val (input, output) = readln().split(" ")
        println(if (input == output) "OK" else "ERROR")
    }
}