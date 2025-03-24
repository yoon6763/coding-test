package baekjoon.bronze.b4

fun main() {
    val food = List(readln().toInt()) { readln().toInt() }
    print(List(readln().toInt()){ food[readln().toInt()-1] }.sum())
}