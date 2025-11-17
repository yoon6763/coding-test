package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (x, y) = readln().split(" ").map { it.toInt() }
    print(if (x in 0..23 && y in 0..59) "Yes " else "No ")
    println(if (x !in 1..12) "No" else if (y !in 1..arrayOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)[x]) "No" else "Yes")
}
