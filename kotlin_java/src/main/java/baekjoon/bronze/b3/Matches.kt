package baekjoon.bronze.b3

fun main() {
    val (n, w, h) = readln().split(" ").map(String::toInt)

    repeat(n) {
        val len = readln().toInt()
        println(if (len * len <= w * w + h * h) "YES" else "NO")
    }
}