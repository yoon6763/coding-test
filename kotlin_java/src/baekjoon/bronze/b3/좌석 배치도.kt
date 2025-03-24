package baekjoon.bronze.b3

fun main() {
    val arr = Array(10) { Array(20) { '.' } }
    repeat(readln().toInt()) {
        val pos = readln()
        arr[pos[0].toInt() - 'A'.toInt()][pos.substring(1).toInt() - 1] = 'o'
    }
    println(arr.joinToString("\n") { it.joinToString("") })
}