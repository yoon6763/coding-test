package baekjoon.bronze.b5

fun main() {
    if (List(4) { readln().toInt() }.sum() + 300 <= 1800) {
        println("Yes")
    } else {
        println("No")
    }
}