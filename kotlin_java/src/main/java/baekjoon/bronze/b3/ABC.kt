package baekjoon.bronze.b3

fun main() {
    val arr = readln().split(" ").map { it.toInt() }.sorted()
    val abc = readln()
    print(Array(3) { arr[abc[it] - 'A'] }.joinToString(" "))
}