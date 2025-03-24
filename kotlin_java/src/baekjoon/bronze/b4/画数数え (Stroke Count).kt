package baekjoon.bronze.b4

fun main() {
    readln()
    println(readln().sumOf { mapOf('j' to 2, 'o' to 1, 'i' to 2)[it]!! })
}