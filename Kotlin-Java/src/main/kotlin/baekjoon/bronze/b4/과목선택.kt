package baekjoon.bronze.b4

fun main() = with(System.`in`.bufferedReader()) {
    val a1 = Array(4) { 0 }
    repeat(4) {
        a1[it] = readLine().toInt()
    }
    val a2 = Array(2) { 0 }
    repeat(2) {
        a2[it] = readLine().toInt()
    }

    a1.sortDescending()
    a2.sortDescending()

    println(a1[0] + a1[1] + a1[2] + a2[0])
}