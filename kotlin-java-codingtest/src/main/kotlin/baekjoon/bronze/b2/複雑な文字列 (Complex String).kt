package baekjoon.bronze.b2

fun main() {
    readln()
    println(if (readln().toCharArray().distinct().size >= 3) "Yes" else "No")
}