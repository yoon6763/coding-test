package baekjoon.bronze.b4

fun main() {
    val p = readln().toInt()
    val c = readln().toInt()
    print(p * 50 - c * 10 + if (p > c) 500 else 0)
}