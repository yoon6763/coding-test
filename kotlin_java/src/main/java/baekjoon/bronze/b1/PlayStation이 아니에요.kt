package baekjoon.bronze.b1

fun main() {
    readln()
    println(generateSequence(readln()) { it.replace("PS4", "PS").replace("PS5", "PS") }
        .first { "PS4" !in it && "PS5" !in it })
}