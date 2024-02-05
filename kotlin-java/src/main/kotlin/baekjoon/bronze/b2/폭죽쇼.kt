package baekjoon.bronze.b2

fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val fire = IntArray(c + 1)
    repeat(n) {
        val num = readln().toInt()
        for (k in num..c step num) {
            fire[k] = 1
        }
    }
    println(fire.sum())
}
