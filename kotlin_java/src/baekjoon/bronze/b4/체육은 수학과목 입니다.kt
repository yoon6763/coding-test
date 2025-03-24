package baekjoon.bronze.b4

fun main() {
    val h = readln().toInt()
    val w = readln().toInt()
    println(if (h < w) h * 50 else w * 50)
}
