package baekjoon.bronze.b4

fun main() {
    val cnt = IntArray(10)
    repeat(5) {
        cnt[readln().toInt()]++
    }
    for (i in 0..9) {
        if (cnt[i] % 2 == 1) {
            println(i)
            break
        }
    }
}